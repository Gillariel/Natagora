/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author foers
 */
public class VisionChecker {
    /**
     * 
     * @param url
     * @return 0 = nothing correct, 1 = ok, 2 = bad content (pending)
     */
    public static int check(String url) {
        return checkAndRetry(url, 3);
    }
    
    private static int checkAndRetry(String url, int cpt) {
        Client c = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        WebTarget w = c.target("https://vision.googleapis.com/v1/images:annotate?key=AIzaSyDqg1WuLTP1-rfyPKybB_kl41VaxVHG-08");
        try {
            String json = "{\n" +
                        "  \"requests\":[\n" +
                        "    {\n" +
                        "      \"image\":{\n" +
                        "        \"source\":{\n" +
                        "          \"imageUri\":\n" +
                        "            \"" + url + "\"\n" +
                        "        }\n" +
                        "      },\n" +
                        "      \"features\":[\n" +
                        "        {\n" +
                        "          \"type\":\"LABEL_DETECTION\",\n" +
                        "          \"maxResults\":10\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"type\":\"SAFE_SEARCH_DETECTION\",\n" +
                        "          \"maxResults\":5\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                String res = w.request().accept(MediaType.APPLICATION_JSON).buildPost(Entity.json(json)).invoke().readEntity(String.class);

                JSONObject response = new JSONObject(res).getJSONArray("responses").getJSONObject(0);

                System.out.println(response);

                JSONObject safeSearch = response.getJSONObject("safeSearchAnnotation");

                // Checking Safe search
                String a = safeSearch.getString("adult");
                String b = safeSearch.getString("spoof");
                String d = safeSearch.getString("medical");
                String e = safeSearch.getString("violence");

                if(a.equals("LIKELY") || a.equals("VERY_LIKELY") ||
                    b.equals("LIKELY") || b.equals("VERY_LIKELY") ||
                    d.equals("LIKELY") || d.equals("VERY_LIKELY") ||
                    e.equals("LIKELY") || e.equals("VERY_LIKELY")) {
                    c.close();    
                    return 2;
                }

                // Checking birds cat
                for(Object o : response.getJSONArray("labelAnnotations")) {
                    String desc = ((JSONObject) o).getString("description");
                    if(desc.contains("bird") || desc.contains("birds")) {
                        c.close();
                        return 1;
                    }     
                }
                return 0;
        }catch(JSONException ex1){
            System.out.println("Json Parsing not correct (No result from api)");
            System.out.println("[Message] " + ex1.getMessage());
            System.out.print("[StackTrace] "); 
            ex1.printStackTrace();
            return (cpt == 0) ? 0 : checkAndRetry(url, cpt--);
        }catch(Exception ex2){
            System.out.println("Unexplained error");
            System.out.println("[Message] " + ex2.getMessage());
            System.out.print("[StackTrace] "); 
            ex2.printStackTrace();
            return (cpt == 0) ? 0 : checkAndRetry(url, cpt--);
        } 
    }
}
