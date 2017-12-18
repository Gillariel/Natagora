package al.helmo.com.natamobile.model;

public class Media {

private int id;
private String name;
private String url;
private String text;
private boolean validated;
private boolean deleted;
private MediaType mediaType;

public Media(String name, String url, MediaType mediaType){
    setId(0);
    setName(name);
    setUrl(url);
    setText("");
    setValidated(false);
    setDeleted(false);
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

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
