/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Forums_Dev")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "ForumsDev.findAll", query = "SELECT f FROM ForumsDev f")
    , @NamedQuery(name = "ForumsDev.findById", query = "SELECT f FROM ForumsDev f WHERE f.id = :id")
    , @NamedQuery(name = "ForumsDev.findByLikes", query = "SELECT f FROM ForumsDev f WHERE f.likes = :likes")
    , @NamedQuery(name = "ForumsDev.findByDislike", query = "SELECT f FROM ForumsDev f WHERE f.dislike = :dislike")})*/
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "Likes")
    private int likes;
    
    @Basic(optional = false)
    @Column(name = "Dislike")
    private int dislike;
    
    @JoinTable(name = "Tags_Forums_Dev", joinColumns = {
        @JoinColumn(name = "Forum_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Tag_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Tag> tagsDevCollection;
    
    @ManyToMany(mappedBy = "forumsDevCollection")
    private Collection<Comment> commentsDevCollection;
    
    @JoinColumn(name = "Session_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Session session;
    
    
    public Forum() {
    }

    public Forum(Integer id) {
        this.id = id;
    }

    public Forum(Integer id, int likes, int dislike) {
        this.id = id;
        this.likes = likes;
        this.dislike = dislike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    
    public Collection<Tag> getTagsDevCollection() {
        return tagsDevCollection;
    }

    public void setTagsDevCollection(Collection<Tag> tagsDevCollection) {
        this.tagsDevCollection = tagsDevCollection;
    }

    
    public Collection<Comment> getCommentsDevCollection() {
        return commentsDevCollection;
    }

    public void setCommentsDevCollection(Collection<Comment> commentsDevCollection) {
        this.commentsDevCollection = commentsDevCollection;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
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
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.helmo.al.natarest.entity.ForumsDev[ id=" + id + " ]";
    }
    
}
