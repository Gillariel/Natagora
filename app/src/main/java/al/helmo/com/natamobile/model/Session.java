package al.helmo.com.natamobile.model;

import java.util.ArrayList;
import java.util.List;

class Session {

    private List<Observation> observations;
    private int id;
    //private double longitude;
    //private double latitude;

    Session(int id, double latitude, double longitude){
        observations = new ArrayList<>();
        this.id = id;
        //this.latitude = latitude;
        //this.longitude = longitude;
    }

    void addObservation(Observation observation) {
        observations.add(observation);
    }

    List<Observation> getObservations() {
        return observations;
    }
}
