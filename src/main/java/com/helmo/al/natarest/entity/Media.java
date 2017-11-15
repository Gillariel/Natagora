/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Media_Dev")
@XmlRootElement
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Url")
    @Basic(optional = true)
    private String url;
    
    @Column(name = "Text")
    @Basic(optional = true)
    private String text;
    
    @Basic(optional = false)
    @Column(name = "Validated")
    private short validated;
    
    @JoinColumn(name = "MediaType_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private MediaTypeDB mediaType;

    public Media() {
    }

    public Media(Integer id) {
        this.id = id;
    }

    public Media(Integer id, String name, short validated) {
        this.id = id;
        this.name = name;
        this.validated = validated;
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

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public short getValidated() {
        return validated;
    }
    public void setValidated(short validated) {
        this.validated = validated;
    }

    public MediaTypeDB getMediaTypeID() {
        return mediaType;
    }
    public void setMediaTypeID(MediaTypeDB mediaTypeID) {
        this.mediaType = mediaTypeID;
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
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.mediaType.getType() + ")";
    }
    
}
