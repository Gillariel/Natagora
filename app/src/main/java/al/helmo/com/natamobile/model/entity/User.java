package al.helmo.com.natamobile.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    private int id;
    private String pseudo;
    private String name;
    private String forname;
    private String mail;
    private String password;
    private String picture;
    private Role role;

    public User(Parcel in) {
        id = in.readInt();
        pseudo = in.readString();
        name = in.readString();
        forname = in.readString();
        mail = in.readString();
        password = in.readString();
        picture = in.readString();
        role = in.readParcelable(Role.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(int id, String pseudo, String name, String forname, String mail) {
        setId(id);
        setPseudo(pseudo);
        setName(name);
        setForname(forname);
        setMail(mail);
        setPassword("");
        setPicture("");
        setRole(new Role(1,"User"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(pseudo);
        parcel.writeString(name);
        parcel.writeString(forname);
        parcel.writeString(mail);
        parcel.writeString(password);
        parcel.writeString(picture);
        parcel.writeParcelable(role,i);
    }
}
