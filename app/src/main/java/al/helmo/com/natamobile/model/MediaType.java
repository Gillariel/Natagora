package al.helmo.com.natamobile.model;

public class MediaType {

    private int id;
    private String type;

    public MediaType(int id, String type){
        setId(id);
        setType(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
