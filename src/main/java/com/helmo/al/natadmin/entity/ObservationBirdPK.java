/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author foers
 */
@Embeddable
public class ObservationBirdPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Observation_ID")
    private int observationID;
    @Basic(optional = false)
    @Column(name = "Bird_ID")
    private int birdID;

    public ObservationBirdPK() {
    }

    public ObservationBirdPK(int observationID, int birdID) {
        this.observationID = observationID;
        this.birdID = birdID;
    }

    public int getObservationID() {
        return observationID;
    }

    public void setObservationID(int observationID) {
        this.observationID = observationID;
    }

    public int getBirdID() {
        return birdID;
    }

    public void setBirdID(int birdID) {
        this.birdID = birdID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) observationID;
        hash += (int) birdID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationBirdPK)) {
            return false;
        }
        ObservationBirdPK other = (ObservationBirdPK) object;
        if (this.observationID != other.observationID) {
            return false;
        }
        if (this.birdID != other.birdID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.ObservationsBirdsDevPK[ observationID=" + observationID + ", birdID=" + birdID + " ]";
    }
    
}
