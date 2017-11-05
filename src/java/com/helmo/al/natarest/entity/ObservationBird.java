/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

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
@Table(name = "Observations_Birds_Dev")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "ObservationsBirdsDev.findAll", query = "SELECT o FROM ObservationsBirdsDev o")
    , @NamedQuery(name = "ObservationsBirdsDev.findByObservationID", query = "SELECT o FROM ObservationsBirdsDev o WHERE o.observationsBirdsDevPK.observationID = :observationID")
    , @NamedQuery(name = "ObservationsBirdsDev.findByBirdID", query = "SELECT o FROM ObservationsBirdsDev o WHERE o.observationsBirdsDevPK.birdID = :birdID")})*/
public class ObservationBird implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservationBirdPK observationsBirdsDevPK;
    @JoinColumn(name = "Bird_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bird birdsDev;
    @JoinColumn(name = "Observation_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Observation observationsDev;

    public ObservationBird() {
    }

    public ObservationBird(ObservationBirdPK observationsBirdsDevPK) {
        this.observationsBirdsDevPK = observationsBirdsDevPK;
    }

    public ObservationBird(int observationID, int birdID) {
        this.observationsBirdsDevPK = new ObservationBirdPK(observationID, birdID);
    }

    public ObservationBirdPK getObservationsBirdsDevPK() {
        return observationsBirdsDevPK;
    }

    public void setObservationsBirdsDevPK(ObservationBirdPK observationsBirdsDevPK) {
        this.observationsBirdsDevPK = observationsBirdsDevPK;
    }

    public Bird getBirdsDev() {
        return birdsDev;
    }

    public void setBirdsDev(Bird birdsDev) {
        this.birdsDev = birdsDev;
    }

    public Observation getObservationsDev() {
        return observationsDev;
    }

    public void setObservationsDev(Observation observationsDev) {
        this.observationsDev = observationsDev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationsBirdsDevPK != null ? observationsBirdsDevPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationBird)) {
            return false;
        }
        ObservationBird other = (ObservationBird) object;
        if ((this.observationsBirdsDevPK == null && other.observationsBirdsDevPK != null) || (this.observationsBirdsDevPK != null && !this.observationsBirdsDevPK.equals(other.observationsBirdsDevPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.ObservationsBirdsDev[ observationsBirdsDevPK=" + observationsBirdsDevPK + " ]";
    }
    
}
