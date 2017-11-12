package al.helmo.com.natamobile.model;

/**
 * Created by patri on 12/11/2017.
 */

public class User {
    private String name;
    private String email;
    private String password;

    public User(){

    }

    public User (User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}