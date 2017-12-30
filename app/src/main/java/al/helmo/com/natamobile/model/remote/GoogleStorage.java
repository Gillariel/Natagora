package al.helmo.com.natamobile.model.remote;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;

public class GoogleStorage {

    private static Properties properties;
    private static Storage storage;
    private static final String APPLICATION_NAME_PROPERTY = "application.name";


    public void uploadFile(String username, int sessionId, File filePath, Context mContext)throws Exception{
        try{
            Storage storage = getStorage(mContext);

            File file = new File(filePath.getAbsolutePath());
            InputStream stream = new FileInputStream(file);
            try {
                String contentType = URLConnection.guessContentTypeFromStream(stream);
                InputStreamContent content = new InputStreamContent(contentType, stream);
                Storage.Objects.Insert insert = storage.objects().insert("natamobile", null, content);
                insert.setName(username+"/"+ sessionId +"/" +file.getName());
                insert.setPredefinedAcl("publicRead");
                insert.execute();
            }finally {
                stream.close();
            }
        }catch (Exception e){
            class Local {}; Log.d("","Sub :"+Local.class.getEnclosingMethod().getName() +"Error Code" +e.getMessage());
            e.printStackTrace();
        }

    }

    private static Properties getProperties() throws Exception {

        if (properties == null) {
            properties = new Properties();
            InputStream stream = GoogleStorage.class
                    .getResourceAsStream("/assets/cloudstorage.properties");
            try {
                properties.load(stream);
            } catch (IOException e) {
                throw new RuntimeException(
                        "cloudstorage.properties must be present in classpath",
                        e);
            } finally {
                stream.close();
            }
        }
        return properties;
    }

    private static Storage getStorage(Context mContext)throws Exception{
        if(storage == null){
            HttpTransport httpTransport = new NetHttpTransport();
            JacksonFactory jacksonFactory = new JacksonFactory();

            List<String> scopes = new ArrayList<>();
            scopes.add(StorageScopes.DEVSTORAGE_FULL_CONTROL);

            Credential credential = new GoogleCredential.Builder()
                    .setTransport(httpTransport)
                    .setJsonFactory(jacksonFactory)
                    .setServiceAccountId("monfoe@monfoe-181813.iam.gserviceaccount.com")
                    .setServiceAccountPrivateKeyFromP12File(getKeyp12(mContext))
                    .setServiceAccountScopes(scopes).build();

            storage = new Storage.Builder(httpTransport, jacksonFactory, credential)
                    .setApplicationName(getProperties().getProperty(APPLICATION_NAME_PROPERTY))
                    .build();
        }
        return storage;
    }

    private static File getKeyp12(Context mContext) {
        try {
            // xxx.p12 export from google API console
            InputStream pkc12Stream =   mContext.getAssets().open("key/MONFOE-619c7b3b7428.p12");
            File tempPkc12File = File.createTempFile("MONFOE-121212", "p12");
            OutputStream tempFileStream = new FileOutputStream(tempPkc12File);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = pkc12Stream.read(bytes)) != -1) {
                tempFileStream.write(bytes, 0, read);
            }
            return tempPkc12File;
        }catch(Exception e)
        {
            e.printStackTrace();

        }
        return null;
    }
}