/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.JokeClient;
import com.helmo.al.natadmin.entity.Joke;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */
@ManagedBean
@RequestScoped
public class JokeHandler {
    public List<Joke> random() {
        return new JokeClient().random();
    }
}
