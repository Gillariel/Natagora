package al.helmo.com.natamobile.model.entity;

import al.helmo.com.natamobile.model.entity.User;

public class Session {

    private int id;
    private boolean validated;
    private long date;
    private double latitude;
    private double longitude;
    private String comment;
    private String weather;
    private User user;


    public Session(int id, double latitude, double longitude, User user){
        setId(id);
        setLatitude(latitude);
        setLongitude(longitude);
        setUser(user);
        setDate(System.currentTimeMillis());
        setComment("");
        setValidated(false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {this.longitude = longitude;}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
