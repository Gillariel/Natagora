package al.helmo.com.natamobile.model.entity;

public class Observation {

    private int id;
    private long date;
    private Bird bird;
    private Media media;
    private Session session;
    private String note;

    public Observation(Bird bird, Media media, Session session){
        setId(0);
        setDate(System.currentTimeMillis());
        setBird(bird);
        setMedia(media);
        setSession(session);
        setNote("");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String notes) {
        this.note = notes;
    }
}
