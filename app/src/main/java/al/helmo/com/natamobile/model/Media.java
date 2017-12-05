package al.helmo.com.natamobile.model;

import android.net.Uri;

import java.io.File;

public class Media {

    // url = Cloud adress + idClient + n°session + n°of observation + extension;
    private String url ;
    private File localURI;

    public Media (File localURI){

        this.localURI = localURI;
    }

    public File getLocalURI() {
        return localURI;
    }

}
