package al.helmo.com.natamobile.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.fragment.FragmentHandler;
import al.helmo.com.natamobile.fragment.login.LogInFragment;

public class LoginActivity extends AppCompatActivity {

    private FragmentHandler fragmentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        fragmentHandler = new FragmentHandler();
        fragmentHandler.replaceLogFragment(new LogInFragment(), getFragmentManager());
    }

    public FragmentHandler getFragmentHandler() {
        return fragmentHandler;
    }
}
