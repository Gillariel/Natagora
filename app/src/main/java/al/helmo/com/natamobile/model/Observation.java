package al.helmo.com.natamobile.model;

import java.util.ArrayList;
import java.util.List;

public class Observation {

    private int id;
    private long date;
    private Bird bird;
    private Media media;
    private Session session;
    private List<Notes> notes;

    public Observation(Bird bird, Media media, Session session){
        setId(0);
        setDate(System.currentTimeMillis()/1000);
        setBird(bird);
        setMedia(media);
        setSession(session);
        notes = new ArrayList<>();
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

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
