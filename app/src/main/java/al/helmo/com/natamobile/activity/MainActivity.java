package al.helmo.com.natamobile.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.fragment.login.LogOutFragment;
import al.helmo.com.natamobile.fragment.main.GalleryGridFragment;
import al.helmo.com.natamobile.fragment.main.SelectMediaFragment;
import al.helmo.com.natamobile.fragment.main.SessionFragment;
import al.helmo.com.natamobile.fragment.main.SettingsFragment;
import al.helmo.com.natamobile.fragment.FragmentHandler;
import al.helmo.com.natamobile.model.SessionManager;
import al.helmo.com.natamobile.model.entity.User;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private FragmentHandler fragmentHandler;
    private SessionManager sessionManager;
    private Button sessionButton, galleryButton, addButton, settingsButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = getIntent().getParcelableExtra("user");
        sessionManager = new SessionManager(user);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        fragmentHandler = new FragmentHandler();
        sessionButton = (Button)findViewById(R.id.mysession);
        galleryButton = (Button)findViewById(R.id.gallery);
        addButton = (Button)findViewById(R.id.addobservation);
        settingsButton = (Button)findViewById(R.id.settings);
        logoutButton = (Button)findViewById(R.id.logout);
        listView = (RelativeLayout)findViewById(R.id.menuBurger);

        fragmentHandler.replaceFragment(new SessionFragment(), getFragmentManager());

        if(sessionManager.getConnectedUser() == null){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            Toast.makeText(this, "Error, No user is currently connected, Log in again Please", Toast.LENGTH_SHORT).show();
        }

        sessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentHandler.replaceFragment(new SessionFragment(), getFragmentManager());
                drawerLayout.closeDrawer(listView);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessionManager.getStatus() == true) {
                    fragmentHandler.replaceFragment(new SelectMediaFragment(), getFragmentManager());
                }else{
                    Toast.makeText(getBaseContext(), "The Session is not started", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(listView);
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessionManager.getStatus() == true){
                    fragmentHandler.replaceFragment(new GalleryGridFragment(), getFragmentManager());
                }else{
                    Toast.makeText(getBaseContext(), "The Session is not started", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(listView);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessionManager.getStatus() == false){
                    fragmentHandler.replaceFragment(new SettingsFragment(), getFragmentManager());
                }else{
                    Toast.makeText(getBaseContext(), "End your Session before editing your account", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(listView);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentHandler.replaceFragment(new LogOutFragment(), getFragmentManager());
                drawerLayout.closeDrawer(listView);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout.closeDrawer(listView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
           return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public FragmentHandler getFragmentHandler() {
        return fragmentHandler;
    }
}
