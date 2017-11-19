/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.StatisticsClient;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class StatisticHandler {

    private final StatisticsClient client = new StatisticsClient();
    
    public StatisticHandler() { }
    
    public Long birds() { return client.get("birds"); }
    public Long comments() { return client.get("comments"); }
    public Long media() { return client.get("media"); }
    public Long observations() { return client.get("observations"); }
    public Long sessions() { return client.get("sessions"); }
    public Long users() { return client.get("users"); }
    public Long lastUsers() { return client.get("lastUsers"); }
    public Long commentsByForum(int id) { return client.getByID("comments/", id); }
    public Long mediaByType(int id) { return client.getByID("media/", id); }
    public Long seeBirds(int id) { return client.getByID("birds/", id); }
    public Long observationsBySession(int id) { return client.getByID("observations/", id); }
    public Long observationsByUser(int id) { return client.getByID("observations/byUser/", id); }
    public Long sessionsByUser(int id) { return client.getByID("sessions/", id); }
}
