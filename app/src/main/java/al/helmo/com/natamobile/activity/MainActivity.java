package al.helmo.com.natamobile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import al.helmo.com.natamobile.R;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = (TextView) findViewById(R.id.txtUsername);

        Bundle extras = getIntent().getExtras();
        String username;
        if(extras != null){
            username = extras.getString("username");
            txtUsername.setText(username);
        }
    }
}
