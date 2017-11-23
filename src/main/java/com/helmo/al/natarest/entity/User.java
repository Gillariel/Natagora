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
@Table(name = "Users_Dev")
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Pseudo")
    private String pseudo;
    
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "Forname")
    private String forname;
    
    @Basic(optional = false)
    @Column(name = "Mail")
    private String mail;
    
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;   

    @Basic(optional = false)
    @Column(name = "Picture")
    private String picture;
    
    @JoinColumn(name = "Role_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Role role;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String pseudo, String name, String forname, String mail, String password, String pic) {
        this.id = id;
        this.pseudo = pseudo;
        this.name = name;
        this.forname = forname;
        this.mail = mail;
        this.password = password;
        this.picture = pic;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }
    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return this.name + " " + this.forname;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.pseudo + " (" + this.getFullName() + ")";
    }
    
}
