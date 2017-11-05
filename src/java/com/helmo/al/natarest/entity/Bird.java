/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Birds_Dev")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "BirdsDev.findAll", query = "SELECT b FROM BirdsDev b")
    , @NamedQuery(name = "BirdsDev.findById", query = "SELECT b FROM BirdsDev b WHERE b.id = :id")
    , @NamedQuery(name = "BirdsDev.findByName", query = "SELECT b FROM BirdsDev b WHERE b.name = :name")
    , @NamedQuery(name = "BirdsDev.findByLength", query = "SELECT b FROM BirdsDev b WHERE b.length = :length")
    , @NamedQuery(name = "BirdsDev.findByWeight", query = "SELECT b FROM BirdsDev b WHERE b.weight = :weight")})*/
public class Bird implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Length")
    private Integer length;
    @Column(name = "Weight")
    private Integer weight;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "birdsDev")
    private ObservationBird observationsBirdsDev;

    public Bird() {
    }

    public Bird(Integer id) {
        this.id = id;
    }

    public Bird(Integer id, String name) {
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ObservationBird getObservationsBirdsDev() {
        return observationsBirdsDev;
    }

    public void setObservationsBirdsDev(ObservationBird observationsBirdsDev) {
        this.observationsBirdsDev = observationsBirdsDev;
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
        if (!(object instanceof Bird)) {
            return false;
        }
        Bird other = (Bird) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.BirdsDev[ id=" + id + " ]";
    }
    
}
