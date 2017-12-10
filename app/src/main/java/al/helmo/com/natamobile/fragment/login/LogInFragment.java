package al.helmo.com.natamobile.fragment.login;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.APIUtils;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInFragment extends Fragment {

    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnRegister;
    private UserService userService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);

        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        userService = APIUtils.getUserService();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(!validateLogIn(username, password)){
                    Toast.makeText(getActivity().getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }else{
                    //doLogin(username, password, APIUtils.KEYAPI);
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    i.putExtra("username",username);
                    startActivity(i);
                }
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

    private void doLogin(final String username, String password, String apiKey) {
        Call<Void> call = userService.login(username, apiKey, password);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if (response.code() == 200) {
                    if (true) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        i.putExtra("username", username);
                        startActivity(i);
                    } else {
                        Toast.makeText(getActivity(), "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Error, Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
