package al.helmo.com.natamobile.model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Observation> observations;
    private double longitude;
    private double latitude;

    public Session(double latitude, double longitude){
        observations = new ArrayList<>();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void addObservation(Observation observation) {
        observations.add(observation);
    }

    public List<Observation> getObservations() {
        return observations;
    }
}
