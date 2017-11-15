/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "Observations_Dev")
@XmlRootElement
public class Observation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    
    @JoinTable(name = "Observations_Birds_Dev", joinColumns = {
        @JoinColumn(name = "Observation_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Bird_ID", referencedColumnName = "ID")})
    @ManyToMany()
    private Collection<Bird> birds;
    
    @OneToOne()
    @JoinTable(name = "Media_Dev", 
            joinColumns = @JoinColumn(name = "Observation_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID")
    )
    private Media media;
    
    @JoinColumn(name = "Session_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Session session;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Notes_Dev",
            joinColumns = @JoinColumn(name = "Observation_ID"),
            inverseJoinColumns = @JoinColumn(name = "ID")
    )
    private Collection<Note> notes;
    
    public Observation() {
    }

    public Observation(Integer id) {
        this.id = id;
    }

    public Observation(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Bird> getBirds() {
        return birds;
    }
    public void setBirds(Collection<Bird> birds) {
        this.birds = birds;
    }
    
    
    public Media getMediaDev() {
        return media;
    }
    public void setMediaDev(Media media) {
        this.media = media;
    }

    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }

    
    public Collection<Note> getNotes() {
        return notes;
    }
    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
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
        if (!(object instanceof Observation)) {
            return false;
        }
        Observation other = (Observation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(this.session != null) {
            if(this.session.getUser() != null) {
                return "Observation " + this.id + " of session " + this.session.getId() + " (belong to" + this.session.getUser().getPseudo() + ")";
            }
        }
        return "Observation link to no one (id :" + this.id + ")";
    }
    
}
