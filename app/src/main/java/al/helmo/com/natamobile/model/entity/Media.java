package al.helmo.com.natamobile.model.entity;

import al.helmo.com.natamobile.model.entity.MediaType;

public class Media {

private int id;
private String name;
private String url;
private String text;
private int validated;
private int deleted;
private MediaType mediaType;

public Media(String name, String url, MediaType mediaType){
    setId(0);
    setName(name);
    setUrl(url);
    setText("");
    setValidated(0);
    setDeleted(0);
    setMediaType(mediaType);
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValidated() {
        return validated;
    }

    public void setValidated(int validated) {
        this.validated = validated;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
