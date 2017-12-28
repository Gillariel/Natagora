/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.util;

import com.helmo.al.natadmin.security.Global;
import com.sun.media.jfxmedia.logging.Logger;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;

/**
 *
 * @author foers
 */
public class CompletelyDeprecateSSLDestroyerDueToBadServer {
    public static Client DestroyEverything() {
        Client c = null;
        TrustManager[] trustManager = new X509TrustManager[] { new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }};
        try {
            SSLContext sslContext = null;
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManager, new java.security.SecureRandom());

            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            c = javax.ws.rs.client.ClientBuilder.newBuilder().sslContext(sslContext).hostnameVerifier(hv).build();
        }catch(Exception e) {
            c = null;
        }
        System.out.println("Have pass SSL Certificat security beacause there is none, maybe time to buy one don't you think?");
        return c;
    }
    
    public static HttpsURLConnection DestroyLittlePiece(HttpsURLConnection con) {
        TrustManager[] trustManager = new X509TrustManager[] { new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }};
        try {
            SSLContext sslContext = null;
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManager, new java.security.SecureRandom());
            
            
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            con.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            con.setHostnameVerifier(hv);
        }catch(Exception e) {
            return con;
        }
        System.out.println("Have pass SSL Certificat security beacause there is none, maybe time to buy one don't you think?");
        return con;
    }
}
