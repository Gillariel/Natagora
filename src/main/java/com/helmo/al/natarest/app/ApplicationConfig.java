/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.app;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author foers
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.helmo.al.natarest.filter.AuthFilter.class);
        resources.add(com.helmo.al.natarest.filter.CorsFilter.class);
        resources.add(com.helmo.al.natarest.service.ApplicationsServices.class);
        resources.add(com.helmo.al.natarest.service.BirdsService.class);
        resources.add(com.helmo.al.natarest.service.CommentsService.class);
        resources.add(com.helmo.al.natarest.service.ForumsService.class);
        resources.add(com.helmo.al.natarest.service.MediaService.class);
        resources.add(com.helmo.al.natarest.service.MediaTypeService.class);
        resources.add(com.helmo.al.natarest.service.NotesService.class);
        resources.add(com.helmo.al.natarest.service.ObservationsService.class);
        resources.add(com.helmo.al.natarest.service.RolesService.class);
        resources.add(com.helmo.al.natarest.service.SessionsService.class);
        resources.add(com.helmo.al.natarest.service.StatisticsService.class);
        resources.add(com.helmo.al.natarest.service.TagsService.class);
        resources.add(com.helmo.al.natarest.service.UsersService.class);
    }
    
}
