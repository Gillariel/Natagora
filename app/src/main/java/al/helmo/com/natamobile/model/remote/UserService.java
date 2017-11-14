package al.helmo.com.natamobile.model.remote;

import al.helmo.com.natamobile.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("login/{username}")
    Call<User> login(@Path("username")String username);
}
