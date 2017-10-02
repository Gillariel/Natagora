/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author foers
 */
@javax.ws.rs.ApplicationPath("webresources")
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
        resources.add(Services.BirdsFacadeREST.class);
        resources.add(Services.CommentsFacadeREST.class);
        resources.add(Services.ForumsFacadeREST.class);
        resources.add(Services.MediaFacadeREST.class);
        resources.add(Services.MediaTypeFacadeREST.class);
        resources.add(Services.NotesFacadeREST.class);
        resources.add(Services.OAuthFacadeREST.class);
        resources.add(Services.ObservationsBirdsFacadeREST.class);
        resources.add(Services.ObservationsFacadeREST.class);
        resources.add(Services.RolesFacadeREST.class);
        resources.add(Services.SessionsFacadeREST.class);
        resources.add(Services.TagsFacadeREST.class);
        resources.add(Services.UsersFacadeREST.class);
    }
    
}
