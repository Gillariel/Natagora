package al.helmo.com.natamobile.model;

import android.content.Context;
import android.os.SystemClock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import al.helmo.com.natamobile.model.remote.GoogleStorage;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionManager{

    private Session session;
    private User connectedUser;
    private boolean status = false;
    private UserService userService;
    private List<LocalObservation> localObservations;
    private BirdsHandler birdsHandler;
    private GoogleStorage googleStorage;
    private List<Observation> observations;
    private Context context;

    public SessionManager(User user){
        connectedUser = user;
        userService = APIUtils.getUserService();
        birdsHandler = new BirdsHandler();
        googleStorage = new GoogleStorage();
    }

    public void startNewSession(final double latitude,final double longitude){
        localObservations = new ArrayList<>();
        session = new Session(0, latitude, longitude, connectedUser);
        userService = APIUtils.getUserService();

        Call<Session> call = userService.postSession(APIUtils.KEYAPI,"application/json" , session);

        SystemClock.sleep(150);
        call.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                if(  response.code()>=200 && response.code()<=205){
                    status = true;
                    session.setId(response.body().getId());
                    session.setWeather(response.body().getWeather());
                    session.setLatitude(response.body().getLatitude());
                    session.setLongitude(response.body().getLongitude());
                }else{
                    String Error = null;
                    try {
                        Error = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    status =false;
                }
            }
            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                status =false;
            }
        });
    }

    public void endSession(Context mContext) throws Exception {
        observations = new ArrayList<>();
        context = mContext;
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (LocalObservation lo : localObservations) {
                    if(lo.getLocalFile() !=  null){
                        try {
                            googleStorage.uploadFile(connectedUser.getName(), lo.getLocalFile(), context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Media m = new Media(lo.getComment(), lo.getLocalFile().getName(), lo.getMediaType());
                        observations.add(new Observation(lo.getBird(), m, session));
                    }
                }
                userService.postObservation(APIUtils.KEYAPI,"", observations);
                Call<Void> call = userService.postObservation(APIUtils.KEYAPI, "application/json",observations);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.code() >=200 && response.code() <= 205 ){

                            status = false;
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        return;
                    }
                });
            }
        };
        thread.start();
    }

    private void deleteAllMedia(){
        for (LocalObservation lo : localObservations) {
            if(lo != null){
                lo.getLocalFile().delete();
            }
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void addObservation(LocalObservation observation){
        localObservations.add(observation);
    }

    public List<LocalObservation> getObservations() {
        return localObservations;
    }

    public BirdsHandler getBirdsHandler() {
        return birdsHandler;
    }

    public User getConnectedUser() {
        return connectedUser;
    }

    public void logout() {
        if(localObservations != null ){
            deleteAllMedia();
        }
        this.connectedUser = null;
        this.session = null;
    }


}
