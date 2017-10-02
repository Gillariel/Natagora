/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author foers
 */
@Entity
@Table(name = "Comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c")
    , @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id")
    , @NamedQuery(name = "Comments.findByMessage", query = "SELECT c FROM Comments c WHERE c.message = :message")
    , @NamedQuery(name = "Comments.findByDate", query = "SELECT c FROM Comments c WHERE c.date = :date")
    , @NamedQuery(name = "Comments.findByLikes", query = "SELECT c FROM Comments c WHERE c.likes = :likes")
    , @NamedQuery(name = "Comments.findByDislikes", query = "SELECT c FROM Comments c WHERE c.dislikes = :dislikes")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Likes")
    private int likes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dislikes")
    private int dislikes;
    @JoinTable(name = "Comments_Forums", joinColumns = {
        @JoinColumn(name = "Comments_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "Forums_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Forums> forumsCollection;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Comments(Integer id, String message, Date date, int likes, int dislikes) {
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
    public Collection<Forums> getForumsCollection() {
        return forumsCollection;
    }

    public void setForumsCollection(Collection<Forums> forumsCollection) {
        this.forumsCollection = forumsCollection;
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
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Comments[ id=" + id + " ]";
    }
    
}
