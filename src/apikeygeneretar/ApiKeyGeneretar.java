/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apikeygeneretar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 *
 * @author foers
 */
public class ApiKeyGeneretar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*UUID apikey = UUID.randomUUID();
        System.out.println(apikey);*/
        
        System.out.println(pingURL("http://192.168.128.13:8081/NataRest", 100000) ? "NataRest available" : "NataRest Down");
    }
    
    public static boolean pingURL(String url, int timeout) {
        url = url.replaceFirst("^https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
   }
}
