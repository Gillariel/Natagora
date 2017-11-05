/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */

/**************************************************************/
/*
/*      THIS CLASS NEED TO CHANGE WITH THE DB
/*  COMMENT - FORUM IS 1-N RELATION, NOT N-N WITH JOIN TABLE
/*
/**************************************************************/


@Entity
@Table(name = "Comments_Dev")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "CommentsDev.findAll", query = "SELECT c FROM CommentsDev c")
    , @NamedQuery(name = "CommentsDev.findById", query = "SELECT c FROM CommentsDev c WHERE c.id = :id")
    , @NamedQuery(name = "CommentsDev.findByMessage", query = "SELECT c FROM CommentsDev c WHERE c.message = :message")
    , @NamedQuery(name = "CommentsDev.findByDate", query = "SELECT c FROM CommentsDev c WHERE c.date = :date")
    , @NamedQuery(name = "CommentsDev.findByLikes", query = "SELECT c FROM CommentsDev c WHERE c.likes = :likes")
    , @NamedQuery(name = "CommentsDev.findByDislikes", query = "SELECT c FROM CommentsDev c WHERE c.dislikes = :dislikes")})*/
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Message")
    private String message;
    @Basic(optional = false)
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "Likes")
    private int likes;
    @Basic(optional = false)
    @Column(name = "Dislikes")
    private int dislikes;
    @JoinTable(name = "Comments_Forums_Dev", joinColumns = {
        @JoinColumn(name = "Comment_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Forum_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Forum> forumsDevCollection;

    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, String message, Date date, int likes, int dislikes) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @XmlTransient
    public Collection<Forum> getForumsDevCollection() {
        return forumsDevCollection;
    }

    public void setForumsDevCollection(Collection<Forum> forumsDevCollection) {
        this.forumsDevCollection = forumsDevCollection;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.CommentsDev[ id=" + id + " ]";
    }
    
}
