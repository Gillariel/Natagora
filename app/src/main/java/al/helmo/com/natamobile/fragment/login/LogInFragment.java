package al.helmo.com.natamobile.fragment.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.LoginActivity;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.util.APIUtils;
import al.helmo.com.natamobile.model.entity.User;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static android.content.Context.MODE_PRIVATE;

public class LogInFragment extends Fragment {

    private EditText edtUsername, edtPassword;
    private UserService userService;
    private LoginActivity loginActivity;
    private LoginButton fbLoginButton;
    private String username="", password="";
    private CallbackManager callbackManager;
    private String firstName, lastName, eMail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        callbackManager = CallbackManager.Factory.create();
        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        Button btnRegister = (Button) view.findViewById(R.id.btnRegister);
        fbLoginButton = (LoginButton) view.findViewById(R.id.facebookLogin);
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        userService = APIUtils.getUserService();
        loginActivity = (LoginActivity)getActivity();

        if(!username.equals("") && !password.equals("")){
            edtUsername.setText(username);
            edtPassword.setText(password);
        }

        SharedPreferences sp1 = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        edtUsername.setText(sp1.getString("username", null));
        edtPassword.setText(sp1.getString("password",null));

        if(!edtUsername.getText().equals("") && !edtPassword.getText().equals("") ){
            doLogin(edtUsername.getText().toString(),edtPassword.getText().toString(), APIUtils.KEYAPI);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(!validateLogIn(username, password)){
                    Toast.makeText(getActivity().getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }else{
                    doLogin(username, password, APIUtils.KEYAPI);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new RegisterFragment();
                loginActivity.getFragmentHandler().replaceLogFragment(fragment, getFragmentManager());
            }
        });

        fbLoginButton.setFragment(this);
        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                fbLoginButton.setReadPermissions(Arrays.asList("public_profile", "email"));

                final GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(final JSONObject object, GraphResponse response) {
                        try {
                            getData(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,first_name,last_name,email");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getActivity().getApplicationContext(), "No Problem, you can create a Natagora Only Account", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getActivity().getApplicationContext(), "Error with the connection with your Facebook App", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void getData(JSONObject object) throws JSONException {
        firstName = object.getString("first_name").toString();
        lastName = object.getString("last_name").toString();
        eMail = object.getString("email").toString();
        Call<Void> call = userService.checkUser(APIUtils.KEYAPI,eMail);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code() == 200 ){
                    Toast.makeText(getActivity().getApplicationContext(), "You have a Natagora/Facebook Account, Log In with it", Toast.LENGTH_SHORT).show();
                }else if(response.code() == 404){
                    Toast.makeText(getActivity().getApplicationContext(), "You don't have a Natagora Account, Register Please", Toast.LENGTH_SHORT).show();
                    RegisterFragment fragment = new RegisterFragment();

                    fragment.setForname(lastName);
                    fragment.setName(firstName);
                    fragment.setMail(eMail);

                    loginActivity.getFragmentHandler().replaceLogFragment(fragment, getFragmentManager());
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Our Server are not available right now, try again later", Toast.LENGTH_SHORT).show();
                }
                LoginManager.getInstance().logOut();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Error, I couln't check if you have an account", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode, data );
    }

    private boolean validateLogIn(String username, String password) {
        if(username == null || username.trim().length()==0){
            Toast.makeText(getActivity(), "Username is required",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length()==0){
            Toast.makeText(getActivity(), "Password is required",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String username, final String password, String apiKey) {
        Call<User> call = userService.login(username, apiKey, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        SharedPreferences sp = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
                        SharedPreferences.Editor ed = sp.edit();
                        ed.putString("username",username);
                        ed.putString("password", password);
                        ed.commit();
                        User u  = response.body();
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        i.putExtra("user", u);
                        startActivity(i);
                    } else {
                        Toast.makeText(getActivity(), "The username or password are incorrect", Toast.LENGTH_SHORT).show();
                        SharedPreferences sp = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
                        SharedPreferences.Editor ed = sp.edit();
                        ed.clear();
                        ed.commit();
                        edtUsername.setText("");
                        edtPassword.setText("");
                    }
                } else {
                    Toast.makeText(getActivity(), "Error, Try Again", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
