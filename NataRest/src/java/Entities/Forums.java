/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Forums")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forums.findAll", query = "SELECT f FROM Forums f")
    , @NamedQuery(name = "Forums.findById", query = "SELECT f FROM Forums f WHERE f.id = :id")
    , @NamedQuery(name = "Forums.findByLikes", query = "SELECT f FROM Forums f WHERE f.likes = :likes")
    , @NamedQuery(name = "Forums.findByDislike", query = "SELECT f FROM Forums f WHERE f.dislike = :dislike")})
public class Forums implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Likes")
    private int likes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dislike")
    private int dislike;
    @ManyToMany(mappedBy = "forumsCollection")
    private Collection<Comments> commentsCollection;
    @JoinTable(name = "Tags_Forums", joinColumns = {
        @JoinColumn(name = "Forums_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Tags_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Tags> tagsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "forumID")
    private Sessions sessions;

    public Forums() {
    }

    public Forums(Integer id) {
        this.id = id;
    }

    public Forums(Integer id, int likes, int dislike) {
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

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    public Sessions getSessions() {
        return sessions;
    }

    public void setSessions(Sessions sessions) {
        this.sessions = sessions;
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
        if (!(object instanceof Forums)) {
            return false;
        }
        Forums other = (Forums) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Forums[ id=" + id + " ]";
    }
    
}
