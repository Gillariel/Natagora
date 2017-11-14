/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.viewmodel;

import com.helmo.al.natarest.entity.*;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author e140577
 */
public class ObservationCircular {
    private Integer id;
    private Date date;
    private Session session;
    private Collection<Note> notes;
    private Collection<Bird> birds;

    public ObservationCircular(Observation o, Collection<Bird> birds) {
        this.id = o.getId();
        this.date = o.getDate();
        this.session = o.getSession();
        this.notes = o.getNotes();
        birds.forEach((b) -> {
            birds.add(b);
        });
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the notes
     */
    public Collection<Note> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }

    /**
     * @return the birds
     */
    public Collection<Bird> getBirds() {
        return birds;
    }

    /**
     * @param birds the birds to set
     */
    public void setBirds(Collection<Bird> birds) {
        this.birds = birds;
    }
}
