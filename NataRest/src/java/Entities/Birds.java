/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Birds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Birds.findAll", query = "SELECT b FROM Birds b")
    , @NamedQuery(name = "Birds.findById", query = "SELECT b FROM Birds b WHERE b.id = :id")
    , @NamedQuery(name = "Birds.findByName", query = "SELECT b FROM Birds b WHERE b.name = :name")})
public class Birds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "birds")
    private ObservationsBirds observationsBirds;

    public Birds() {
    }

    public Birds(Integer id) {
        this.id = id;
    }

    public Birds(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObservationsBirds getObservationsBirds() {
        return observationsBirds;
    }

    public void setObservationsBirds(ObservationsBirds observationsBirds) {
        this.observationsBirds = observationsBirds;
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
        if (!(object instanceof Birds)) {
            return false;
        }
        Birds other = (Birds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Birds[ id=" + id + " ]";
    }
    
}
