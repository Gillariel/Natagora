package al.helmo.com.natamobile.model;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestBuilder {

    public static final int POST_TYPE   = 1;
    public static final int GET_TYPE    = 2;
    public static final int PUT_TYPE    = 3;
    public static final int DELETE_TYPE = 4;

    /**
     * HTTP request header constants
     */
    public static final String CONTENT_TYPE         = "Content-Type";
    public static final String ACCEPT_ENCODING      = "Accept-Encoding";
    public static final String CONTENT_ENCODING     = "Content-Encoding";
    public static final String ENCODING_GZIP        = "gzip";
    public static final String MIME_FORM_ENCODED    = "application/x-www-form-urlencoded";
    public static final String MIME_TEXT_PLAIN      = "text/plain";

    public static HttpRequest buildRequest(String urltemp) throws IOException {
        HttpClient client = new DefaultHttpClient();

        URL url = new URL("http://www.android.com/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //readStream(in);
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    /*private InputStream performRequest(final String contentType, final String url, final String user, final String pass,
                                       final Map<String, String> headers, final Map<String, String> params, final int requestType)
            throws IOException {

        DefaultHttpClient client = HTTPClientFactory.newClient();

        client.getParams().setParameter(HttpProtocolParams.USER_AGENT, mUserAgent);

        // process headers using request interceptor
        final Map<String, String> sendHeaders = new HashMap<String, String>();
        if ((headers != null) && (headers.size() > 0)) {
            sendHeaders.putAll(headers);
        }
        if (requestType == HTTPRequestHelper.POST_TYPE || requestType == HTTPRequestHelper.PUT_TYPE ) {
            sendHeaders.put(HTTPRequestHelper.CONTENT_TYPE, contentType);
        }
        // request gzip encoding for response
        sendHeaders.put(HTTPRequestHelper.ACCEPT_ENCODING, HTTPRequestHelper.ENCODING_GZIP);

        if (sendHeaders.size() > 0) {
            client.addRequestInterceptor(new HttpRequestInterceptor() {

                public void process(final HttpRequest request, final HttpContext context) throws HttpException,
                        IOException {
                    for (String key : sendHeaders.keySet()) {
                        if (!request.containsHeader(key)) {
                            request.addHeader(key, sendHeaders.get(key));
                        }
                    }
                }
            });
        }
        return null;
    }*/
}
