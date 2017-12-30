package al.helmo.com.natamobile.fragment.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.util.APIUtils;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {
    private MainActivity mainActivity;
    private UserService userService;
    private EditText oldPassword, newPassword, newPasswordRepeat;
    private LoginButton fbLoginButton;
    private String firstName, lastName, eMail;
    private CallbackManager callbackManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        mainActivity = (MainActivity) this.getActivity();
        userService = APIUtils.getUserService();
        callbackManager = CallbackManager.Factory.create();

        TextView username = (TextView)view.findViewById(R.id.usernameTitle);
        username.setText("Hi "+mainActivity.getSessionManager().getConnectedUser().getPseudo()+", here you can change your password");

        Button editButton = (Button) view.findViewById(R.id.editButton);
        oldPassword = (EditText)view.findViewById(R.id.oldPassword);
        newPassword = (EditText)view.findViewById(R.id.newPassword);
        newPasswordRepeat = (EditText)view.findViewById(R.id.newPasswordRepeat);
        fbLoginButton = (LoginButton)view.findViewById(R.id.editFacebookLogin);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainActivity.getSessionManager().getConnectedUser().getPassword().toString().equals(oldPassword.getText().toString())){
                    if(newPassword.getText().toString().equals(newPasswordRepeat.getText().toString())){
                        mainActivity.getSessionManager().getConnectedUser().setPassword("");

                        Call<Void> call = userService.putUser(APIUtils.KEYAPI,"application/json",newPassword.getText().toString(),mainActivity.getSessionManager().getConnectedUser().getId(),mainActivity.getSessionManager().getConnectedUser());

                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code()>200 && response.code()<205){
                                    Toast.makeText(getActivity().getApplicationContext(), "New Password, Success", Toast.LENGTH_SHORT).show();
                                    mainActivity.getSessionManager().getConnectedUser().setPassword(newPassword.getText().toString());
                                    SharedPreferences sp = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
                                    SharedPreferences.Editor ed = sp.edit();
                                    ed.putString("password", newPassword.getText().toString());
                                }else{
                                    Toast.makeText(getActivity().getApplicationContext(), "New Password, Fail", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(getActivity().getApplicationContext(), "New Password, Fail", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else{
                        Toast.makeText(getActivity().getApplicationContext(), "The new passwords doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Your current password is not correct", Toast.LENGTH_SHORT).show();
                }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode, data );
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
                    Toast.makeText(getActivity().getApplicationContext(), "Your account is already linked with Facebook ", Toast.LENGTH_SHORT).show();
                }else{
                    final String hidePass = mainActivity.getSessionManager().getConnectedUser().getPassword();
                    mainActivity.getSessionManager().getConnectedUser().setPassword("");
                    mainActivity.getSessionManager().getConnectedUser().setName(firstName);
                    mainActivity.getSessionManager().getConnectedUser().setForname(lastName);
                    mainActivity.getSessionManager().getConnectedUser().setMail(eMail);

                    Call<Void> call2 = userService.putUser(APIUtils.KEYAPI,"application/json", hidePass,mainActivity.getSessionManager().getConnectedUser().getId(),mainActivity.getSessionManager().getConnectedUser());

                    call2.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Toast.makeText(getActivity().getApplicationContext(), "Your account is now linked with facebook", Toast.LENGTH_SHORT).show();
                            mainActivity.getSessionManager().getConnectedUser().setPassword(hidePass);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(getActivity().getApplicationContext(), "Error, Your account is NOT linked with facebook", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                LoginManager.getInstance().logOut();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "Error, I couln't check if you have an account", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
