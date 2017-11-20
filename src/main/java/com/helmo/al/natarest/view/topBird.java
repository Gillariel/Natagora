/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.view;

/**
 *
 * @author foers
 */
public class topBird {
    String name;
    String number;

    public topBird() {
    }

    public topBird(String name, String number) {
        this.name = name;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.number;
    }
}
