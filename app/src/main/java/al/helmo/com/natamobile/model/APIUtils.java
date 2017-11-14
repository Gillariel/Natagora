package al.helmo.com.natamobile.model;

import al.helmo.com.natamobile.model.remote.RetrofitClient;
import al.helmo.com.natamobile.model.remote.UserService;

public class APIUtils {

   public final static String KEYAPI = "ce75da30-f691-4d69-af2a-8a198f67e1ba";
   public final static String BASE_URL = "http://192.168.128.13:8081/NataRest/";

   public static UserService getUserService(){
      return RetrofitClient.getClient(BASE_URL).create(UserService.class);
   }
}
