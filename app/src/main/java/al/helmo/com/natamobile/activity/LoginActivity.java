package al.helmo.com.natamobile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.model.User;
import al.helmo.com.natamobile.model.UserRequest;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private EditText edtUsername, edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*btnSignIn = (Button) findViewById(R.id.btnSignIn);
        edtEmail = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);*/

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(email.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }else{
                    UserRequest okok = new UserRequest(Boolean.class,null,null,email, password);
                }
            }
        });
    }
}
