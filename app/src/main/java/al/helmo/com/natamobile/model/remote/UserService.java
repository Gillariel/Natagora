package al.helmo.com.natamobile.model.remote;

import java.util.List;

import al.helmo.com.natamobile.model.Bird;
import al.helmo.com.natamobile.model.Observation;
import al.helmo.com.natamobile.model.User;
import al.helmo.com.natamobile.model.Color;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import al.helmo.com.natamobile.model.Session;

public interface UserService {

    @GET("api/users/login/{username}")
    Call<User> login(@Path("username")String username, @Header("api-key") String apiKey, @Header("passwd") String password);

    @POST("api/sessions")
    Call<Session> postSession(@Header("api-key") String apiKey,@Header("Content-Type") String content ,@Body Session session);

    @POST("api/users")
    Call<Void> postNewUser(@Header("api-key")String apiKey,@Header("Content-Type") String content, @Body User user);

    @PUT("api/users")
    Call<Void> putUser(@Header("api-key")String apiKey,@Header("Content-Type") String content, @Body User user );

    @POST("api/observation")
    Call<Void> postObservation(@Header("api-key")String apiKey, @Header("Content-Type") String content, @Body List<Observation> observations);

    @GET("api/birds")
    Call<List<Bird>> getBirds(@Header("api-key") String apiKey);

    @GET("api/colors")
    Call<List<Color>> getColors(@Header("api-key") String apiKey);
}