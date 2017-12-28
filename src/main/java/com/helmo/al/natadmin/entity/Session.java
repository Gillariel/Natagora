/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "session")
@XmlRootElement
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Validated")
    private boolean validated;
    
    @Basic(optional = false)
    @Column(name = "Date")
    //@Temporal(TemporalType.TIMESTAMP)
    private String date;
    
    @Basic(optional = false)
    @Column(name = "Latitude")
    private float latitude;
    
    @Basic(optional = false)
    @Column(name = "Longitude")
    private float longitude;
    
    @Basic(optional = false)
    @Column(name = "Comment")
    private String comment;
    
    @Basic(optional = true)
    @Column(name = "Weather")
    private String weather;
    
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    @OneToOne(optional = false, cascade = { CascadeType.DETACH })
    private User user;

    public Session() {
    }

    public Session(Integer id) {
        this.id = id;
    }

    public Session(Integer id, boolean validated, String date, float latitude, float longitude, String comment, String weather) {
        this.id = id;
        this.validated = validated;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.comment = comment;
        this.weather = weather;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getValidated() {
        return validated;
    }
    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Session " + this.id + " of " + this.user.getPseudo();
    }
    
}
