/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "forum")
@XmlRootElement
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
    
    @JoinTable(name = "tag_forum", joinColumns = {
        @JoinColumn(name = "Forum_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Tag_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Tag> tags;
    
    @OneToMany(mappedBy = "forum")
    private Collection<Comment> comments;
    
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
 
    public Collection<Tag> getTags() {
        return tags;
    }
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
 
    public Collection<Comment> getComments() {
        return comments;
    }
    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @XmlTransient
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
        return "Forum for session " + this.session.getId();
    }
    
}
