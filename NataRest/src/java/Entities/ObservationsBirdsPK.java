/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author foers
 */
@Embeddable
public class ObservationsBirdsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Observations_ID")
    private int observationsID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Birds_ID")
    private int birdsID;

    public ObservationsBirdsPK() {
    }

    public ObservationsBirdsPK(int observationsID, int birdsID) {
        this.observationsID = observationsID;
        this.birdsID = birdsID;
    }

    public int getObservationsID() {
        return observationsID;
    }

    public void setObservationsID(int observationsID) {
        this.observationsID = observationsID;
    }

    public int getBirdsID() {
        return birdsID;
    }

    public void setBirdsID(int birdsID) {
        this.birdsID = birdsID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) observationsID;
        hash += (int) birdsID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationsBirdsPK)) {
            return false;
        }
        ObservationsBirdsPK other = (ObservationsBirdsPK) object;
        if (this.observationsID != other.observationsID) {
            return false;
        }
        if (this.birdsID != other.birdsID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ObservationsBirdsPK[ observationsID=" + observationsID + ", birdsID=" + birdsID + " ]";
    }
    
}
