package al.helmo.com.natamobile.model;

import java.io.File;

import al.helmo.com.natamobile.model.entity.Bird;
import al.helmo.com.natamobile.model.entity.MediaType;

public class LocalObservation {

    private File localFile;
    private Bird bird;
    private String comment;
    private MediaType mediaType;

    public LocalObservation(File localFile, MediaType mediaType){
        setLocalFile(localFile);
        setMediaType(mediaType);
    }

    public File getLocalFile() {
        return localFile;
    }

    public void setLocalFile(File localFile) {
        this.localFile = localFile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
