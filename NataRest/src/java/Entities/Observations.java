/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Observations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observations.findAll", query = "SELECT o FROM Observations o")
    , @NamedQuery(name = "Observations.findById", query = "SELECT o FROM Observations o WHERE o.id = :id")
    , @NamedQuery(name = "Observations.findByDate", query = "SELECT o FROM Observations o WHERE o.date = :date")
    , @NamedQuery(name = "Observations.findByMediaID", query = "SELECT o FROM Observations o WHERE o.mediaID = :mediaID")})
public class Observations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Media_ID")
    private int mediaID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "observations")
    private ObservationsBirds observationsBirds;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "observationsID")
    private Media media;
    @JoinColumn(name = "Notes_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Notes notesID;
    @JoinColumn(name = "Sessions_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Sessions sessionsID;

    public Observations() {
    }

    public Observations(Integer id) {
        this.id = id;
    }

    public Observations(Integer id, Date date, int mediaID) {
        this.id = id;
        this.date = date;
        this.mediaID = mediaID;
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

    public int getMediaID() {
        return mediaID;
    }

    public void setMediaID(int mediaID) {
        this.mediaID = mediaID;
    }

    public ObservationsBirds getObservationsBirds() {
        return observationsBirds;
    }

    public void setObservationsBirds(ObservationsBirds observationsBirds) {
        this.observationsBirds = observationsBirds;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Notes getNotesID() {
        return notesID;
    }

    public void setNotesID(Notes notesID) {
        this.notesID = notesID;
    }

    public Sessions getSessionsID() {
        return sessionsID;
    }

    public void setSessionsID(Sessions sessionsID) {
        this.sessionsID = sessionsID;
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
        if (!(object instanceof Observations)) {
            return false;
        }
        Observations other = (Observations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Observations[ id=" + id + " ]";
    }
    
}
