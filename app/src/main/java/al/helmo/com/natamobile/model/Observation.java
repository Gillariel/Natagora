package al.helmo.com.natamobile.model;

import android.net.Uri;

import java.io.File;

public class Observation {

    private Media media;
    private String comment;
    private Bird observedBird;

    public Observation(Media media, String comment){
        this.media = media;
        this.comment = comment;
    }

    public File getMediaLocalUrl(){return media.getLocalURI();
    }
}
