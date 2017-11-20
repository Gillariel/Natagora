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
    
    public String birds() { return client.get("birds"); }
    public String comments() { return client.get("comments"); }
    public String media() { return client.get("media"); }
    public String observations() { return client.get("observations"); }
    public String sessions() { return client.get("sessions"); }
    public String users() { return client.get("users"); }
    public String lastUsers() { return client.get("lastUsers"); }
    public String commentsByForum(int id) { return client.getByID("comments/", id); }
    public String mediaByType(int id) { return client.getByID("media/", id); }
    public String seeBirds(int id) { return client.getByID("birds/", id); }
    public String observationsBySession(int id) { return client.getByID("observations/", id); }
    public String observationsByUser(int id) { return client.getByID("observations/byUser/", id); }
    public String sessionsByUser(int id) { return client.getByID("sessions/", id); }
}
