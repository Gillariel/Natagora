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
import al.helmo.com.natamobile.model.APIUtils;
import al.helmo.com.natamobile.model.User;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class LogInFragment extends Fragment {

    private EditText edtUsername, edtPassword;
    private UserService userService;
    private LoginActivity loginActivity;
    private String username="", password="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);

        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        Button btnRegister = (Button) view.findViewById(R.id.btnRegister);
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

        return view;
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
