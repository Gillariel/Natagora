package al.helmo.com.natamobile.model;

import android.content.Context;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

import al.helmo.com.natamobile.model.entity.Media;
import al.helmo.com.natamobile.model.entity.Observation;
import al.helmo.com.natamobile.model.entity.Session;
import al.helmo.com.natamobile.model.entity.User;
import al.helmo.com.natamobile.model.remote.GoogleStorage;
import al.helmo.com.natamobile.model.remote.UserService;
import al.helmo.com.natamobile.model.util.APIUtils;
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
                    status =false;
                }
            }
            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                status =false;
            }
        });
    }

    public void endSession(String comment, Context mContext) throws Exception {
        setComment(comment);
        sendToStorage(mContext);
        sendToRest();
        status=false;
    }

    private void sendToRest() {
        List<LocalObservation> tempObservation = localObservations;
        for (LocalObservation lo : tempObservation) {
            String googleURL ="";
            if(lo.getMediaType().getType()!="Text"){
                googleURL = connectedUser.getPseudo() + "/" + session.getId() + "/" + lo.getLocalFile().getName();
            }
                Media m = new Media(lo.getComment(), googleURL, lo.getMediaType());

                Observation o = new Observation(lo.getBird(), m, session);
                Call<Void> call = userService.postObservation(APIUtils.KEYAPI, "application/json",o );
SystemClock.sleep(10000);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() >= 200 && response.code() <= 205) {

                            status = false;
                        }
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
            }
    }

    private void sendToStorage(Context mContext) {
        context = mContext;

        Thread thread = new Thread() {
            @Override
            public void run() {
                List<LocalObservation> tempObservation = localObservations;
                for (LocalObservation lo : tempObservation) {
                    if(lo.getLocalFile() !=  null){
                        try {
                            googleStorage.uploadFile(connectedUser.getPseudo(),session.getId(), lo.getLocalFile(), context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                deleteAllMedia();
            }
        };
        thread.start();
    }

    private void setComment(String comment) {
        session.setComment(comment);
        Call<Void> call2 = userService.putComment(APIUtils.KEYAPI,"application/json",session.getId(), session );

        call2.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() >= 200 && response.code() <= 205) {
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
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
