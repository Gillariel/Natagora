package al.helmo.com.natamobile.model;

import java.util.List;

import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionManager {

    private Session session;
    private User connectedUser;
    private boolean Status = false;
    private UserService userService;

    public SessionManager(User user){
        connectedUser = user;
        userService = APIUtils.getUserService();
    }

    public void startNewSession(final double latitude,final double longitude){

        Call<Integer> idRequest = userService.getNextSessionID(APIUtils.KEYAPI);
        int id = 0;
        idRequest.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                          if( response.code() >= 200 && response.code() <= 207  ){
                              session = new Session(response.body(), latitude, longitude);
                          }
        }
                       @Override
                       public void onFailure(Call<Integer> call, Throwable t) {

                       }
                   });
        Status = true;
    }

    public void endSession(){
        //send Session to Rest
        Status = false;
    }

    public void deleteAllMedia(){
        for (Observation o : session.getObservations()) {
            o.getMediaLocalUri().delete();
        }
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
