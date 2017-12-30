/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.hystrix;

/**
 *
 * @author foers
 */
public class Validator<T> {

    public synchronized boolean isValid(T entity)
            throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        return (entity != null);
    }
}
