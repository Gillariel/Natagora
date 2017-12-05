package al.helmo.com.natamobile.model.remote;

import al.helmo.com.natamobile.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserService {

    @GET("api/users/login/{username}")
    Call<Void> login(@Path("username")String username, @Header("api-key") String apiKey, @Header("passwd") String password);

    @GET("api/users/{username}")
    Call<User> getUser(@Path("username")String username, @Header("api-key") String apiKey);
}