package al.helmo.com.natamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.model.APIUtils;
import al.helmo.com.natamobile.model.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtUsername, edtPassword;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        userService = APIUtils.getUserService();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(!validateLogIn(username, password)){
                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }else{
                    //doLogin(username, password, APIUtils.KEYAPI);
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("username", username);
                    startActivity(i);
                }
            }
        });
    }

    private boolean validateLogIn(String username, String password) {
        /*if(username == null || username.trim().length()==0){
            Toast.makeText(this, "Username is required",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length()==0){
            Toast.makeText(this, "Password is required",Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }

    private void doLogin(final String username, String password, String apiKey) {
        Call<Void> call = userService.login(username,apiKey,password);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.code() == 200){
                    if(true){
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("username", username);
                        startActivity(i);
                    }else{
                        Toast.makeText(LoginActivity.this,"The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, "Error, Try Again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
