package al.helmo.com.natamobile.model;

import java.io.File;
import java.util.List;

public class SessionManager {

    private Session session;
    private User connectedUser;
    private boolean Status = false;

    public SessionManager(User user){
        connectedUser = user;
    }

    public void startNewSession(double latitude, double longitude){
        session = new Session(latitude, longitude);
        Status = true;
    }

    public void endSession(){
        //send Session to Rest
        Status = false;
    }

    public void deleteAllMedia(){
        /*for (Observation o : session.getObservations()) {
            File file = new File(o.getMediaLocalUrl());
            file.delete();
        }*/
    }

    public boolean getStatus() {
        return Status;
    }

    public void addObservation(Observation observation){
        this.session.addObservation(observation);
    }

    public List<Observation> getSessionObservations(){
        return session.getObservations();
    }
}
