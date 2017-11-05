/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.network;

/**
 *
 * @author foers
 */
public enum NetworkTimeOut {
    NO(Integer.MAX_VALUE),
    SOFT(10000),
    NORMAL(2000),
    HARD(1000),
    SEVERE(500);

    private final int timeout;
    
    NetworkTimeOut(int type) {
        this.timeout = type;
    }

    public int getTimeout() {
        return timeout;
    }
}
