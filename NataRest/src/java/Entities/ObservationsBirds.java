/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Observations_Birds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObservationsBirds.findAll", query = "SELECT o FROM ObservationsBirds o")
    , @NamedQuery(name = "ObservationsBirds.findByObservationsID", query = "SELECT o FROM ObservationsBirds o WHERE o.observationsBirdsPK.observationsID = :observationsID")
    , @NamedQuery(name = "ObservationsBirds.findByBirdsID", query = "SELECT o FROM ObservationsBirds o WHERE o.observationsBirdsPK.birdsID = :birdsID")})
public class ObservationsBirds implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservationsBirdsPK observationsBirdsPK;
    @JoinColumn(name = "Birds_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Birds birds;
    @JoinColumn(name = "Observations_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Observations observations;

    public ObservationsBirds() {
    }

    public ObservationsBirds(ObservationsBirdsPK observationsBirdsPK) {
        this.observationsBirdsPK = observationsBirdsPK;
    }

    public ObservationsBirds(int observationsID, int birdsID) {
        this.observationsBirdsPK = new ObservationsBirdsPK(observationsID, birdsID);
    }

    public ObservationsBirdsPK getObservationsBirdsPK() {
        return observationsBirdsPK;
    }

    public void setObservationsBirdsPK(ObservationsBirdsPK observationsBirdsPK) {
        this.observationsBirdsPK = observationsBirdsPK;
    }

    public Birds getBirds() {
        return birds;
    }

    public void setBirds(Birds birds) {
        this.birds = birds;
    }

    public Observations getObservations() {
        return observations;
    }

    public void setObservations(Observations observations) {
        this.observations = observations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationsBirdsPK != null ? observationsBirdsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationsBirds)) {
            return false;
        }
        ObservationsBirds other = (ObservationsBirds) object;
        if ((this.observationsBirdsPK == null && other.observationsBirdsPK != null) || (this.observationsBirdsPK != null && !this.observationsBirdsPK.equals(other.observationsBirdsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ObservationsBirds[ observationsBirdsPK=" + observationsBirdsPK + " ]";
    }
    
}
