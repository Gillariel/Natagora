package al.helmo.com.natamobile.model.remote;

import java.util.List;

import al.helmo.com.natamobile.model.entity.Bird;
import al.helmo.com.natamobile.model.entity.Observation;
import al.helmo.com.natamobile.model.entity.User;
import al.helmo.com.natamobile.model.entity.Color;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import al.helmo.com.natamobile.model.entity.Session;

public interface UserService {

    @GET("api/users/login/{username}")
    Call<User> login(@Path("username")String username, @Header("api-key") String apiKey, @Header("passwd") String password);

    @POST("api/sessions")
    Call<Session> postSession(@Header("api-key") String apiKey,@Header("Content-Type") String content ,@Body Session session);

    @POST("api/users/secure")
    Call<Void> postNewUser(@Header("api-key")String apiKey,@Header("Content-Type") String content,@Header("passwd") String password, @Body User user);

    @PUT("api/users/secure/{id}")
    Call<Void> putUser(@Header("api-key") String apiKey, @Header("Content-Type") String content,@Header("passwd")String password, @Path("id") int id, @Body User user);

    @POST("api/observations")
    Call<Void> postObservation(@Header("api-key")String apiKey, @Header("Content-Type") String content, @Body Observation observations);

    @GET("api/birds")
    Call<List<Bird>> getBirds(@Header("api-key") String apiKey);

    @GET("api/colors")
    Call<List<Color>> getColors(@Header("api-key") String apiKey);

    @PUT("api/sessions/{id}")
    Call<Void> putComment(@Header("api-key") String apiKey, @Header("Content-Type") String content, @Path("id") int id, @Body Session session);

    @GET("api/users/check/{email}")
    Call<Void> checkUser(@Header("api-key")String apiKey, @Path("email") String email);

}