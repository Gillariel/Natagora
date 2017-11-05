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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Observations_Dev")
@XmlRootElement
//@NamedQueries({
  //  @NamedQuery(name = "ObservationsDev.findAll", query = "SELECT o FROM ObservationsDev o")
    //, @NamedQuery(name = "ObservationsDev.findById", query = "SELECT o FROM ObservationsDev o WHERE o.id = :id")
    //, @NamedQuery(name = "ObservationsDev.findByDate", query = "SELECT o FROM ObservationsDev o WHERE o.date = :date")})
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
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "observationsDev")
    private ObservationBird observationsBirdsDev;
    
    /* DONT KNOW HOW TO GET IT WITHOUT THE KEY
    @JoinColumn(name = "M")
    private MediaDev mediaDev;
    */
    
    @JoinColumn(name = "Session_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Session session;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obervation")
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

    public ObservationBird getObservationsBirdsDev() {
        return observationsBirdsDev;
    }

    public void setObservationsBirdsDev(ObservationBird observationsBirdsDev) {
        this.observationsBirdsDev = observationsBirdsDev;
    }

    /*public MediaDev getMediaDev() {
        return mediaDev;
    }

    public void setMediaDev(MediaDev mediaDev) {
        this.mediaDev = mediaDev;
    }*/

    @XmlTransient
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
        return "com.helmo.al.natarest.entity.ObservationsDev[ id=" + id + " ]";
    }
    
}
