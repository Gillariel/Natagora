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
@Table(name = "Sessions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessions.findAll", query = "SELECT s FROM Sessions s")
    , @NamedQuery(name = "Sessions.findById", query = "SELECT s FROM Sessions s WHERE s.id = :id")
    , @NamedQuery(name = "Sessions.findByValidated", query = "SELECT s FROM Sessions s WHERE s.validated = :validated")
    , @NamedQuery(name = "Sessions.findByDate", query = "SELECT s FROM Sessions s WHERE s.date = :date")
    , @NamedQuery(name = "Sessions.findByLatitude", query = "SELECT s FROM Sessions s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "Sessions.findByLongitude", query = "SELECT s FROM Sessions s WHERE s.longitude = :longitude")})
public class Sessions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Validated")
    private boolean validated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Latitude")
    private float latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Longitude")
    private float longitude;
    @JoinColumn(name = "Forum_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Forums forumID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Users userID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sessionsID")
    private Observations observations;

    public Sessions() {
    }

    public Sessions(Integer id) {
        this.id = id;
    }

    public Sessions(Integer id, boolean validated, Date date, float latitude, float longitude) {
        this.id = id;
        this.validated = validated;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public Forums getForumID() {
        return forumID;
    }

    public void setForumID(Forums forumID) {
        this.forumID = forumID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessions)) {
            return false;
        }
        Sessions other = (Sessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Sessions[ id=" + id + " ]";
    }
    
}
