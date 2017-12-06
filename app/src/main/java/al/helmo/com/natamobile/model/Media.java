package al.helmo.com.natamobile.model;

import android.net.Uri;

import java.io.File;

public class Media {

    // url = Cloud adress + idClient + n°session + n°of observation + extension;
    private String url ;
    private File localFile;

    public Media (File localFile){

        this.localFile = localFile;
    }

    public File getLocalFile() {
        return localFile;
    }

}
