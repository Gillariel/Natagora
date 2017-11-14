/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package com.helmo.al.natarest.entity;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
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
/*@Entity
@Table(name = "Observations_Birds_Dev")
@AssociationOverrides({
    @AssociationOverride(name = "Observations_Dev",
        joinColumns = @JoinColumn(name = "Observation_ID")),
    @AssociationOverride(name = "Birds_Dev",
        joinColumns = @JoinColumn(name = "Bird_ID")) })
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "ObservationsBirdsDev.findAll", query = "SELECT o FROM ObservationsBirdsDev o")
    , @NamedQuery(name = "ObservationsBirdsDev.findByObservationID", query = "SELECT o FROM ObservationsBirdsDev o WHERE o.observationsBirdsDevPK.observationID = :observationID")
    , @NamedQuery(name = "ObservationsBirdsDev.findByBirdID", query = "SELECT o FROM ObservationsBirdsDev o WHERE o.observationsBirdsDevPK.birdID = :birdID")})*/
/*public class ObservationBird implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservationBirdPK pk = new ObservationBirdPK();
    /*@JoinColumn(name = "Bird_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bird bird;
    @JoinColumn(name = "Observation_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Observation observation;*/

    /*public ObservationBird() {
    }

    public ObservationBirdPK getPk() {
        return pk;
    }

    public void setPk(ObservationBirdPK pk) {
        this.pk = pk;
    }

    public Bird getBird() {
        return pk.getBird();
    }

    public void setBird(Bird bird) {
        pk.setBird(bird);
    }

    public Observation getObservation() {
        return pk.getObservation();
    }

    public void setObservation(Observation observation) {
        pk.setObservation(observation);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationBird)) {
            return false;
        }
        ObservationBird other = (ObservationBird) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.ObservationsBirdsDev[ observationsBirdsDevPK=" + pk + " ]";
    }
    
}*/
