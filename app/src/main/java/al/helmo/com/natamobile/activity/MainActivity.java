package al.helmo.com.natamobile.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.fragment.login.LogOutFragment;
import al.helmo.com.natamobile.fragment.main.GalleryGridFragment;
import al.helmo.com.natamobile.fragment.main.SaveSessionFragment;
import al.helmo.com.natamobile.fragment.main.SessionFragment;
import al.helmo.com.natamobile.fragment.main.SettingsFragment;
import al.helmo.com.natamobile.fragment.FragmentHandler;
import al.helmo.com.natamobile.model.SessionManager;
import al.helmo.com.natamobile.model.User;
import al.helmo.com.natamobile.res.ItemSlideMenu;
import al.helmo.com.natamobile.res.MenuBurgerAdapter;

public class MainActivity extends AppCompatActivity {

    private List<ItemSlideMenu> listMenu;
    private MenuBurgerAdapter adapter;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private FragmentHandler fragmentHandler;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extra = getIntent().getExtras();
        User user = new User(extra.getString("username"));
        sessionManager = new SessionManager(user);
        listView = (ListView)findViewById(R.id.menuBurger);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        listMenu = new ArrayList<>();
        fragmentHandler = new FragmentHandler();

        adapter = new MenuBurgerAdapter(this);
        listView.setAdapter(adapter);
        listMenu = adapter.getListItem();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(listMenu.get(0).getTitle());
        listView.setItemChecked(0,true);
        drawerLayout.closeDrawer(listView);

        replaceFragment(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setTitle(listMenu.get(i).getTitle());
                listView.setItemChecked(i, true);
                replaceFragment(i);
                drawerLayout.closeDrawer(listView);
            }
        });

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
    
    private void replaceFragment(int i){
        switch (i){
            case 0:
                fragmentHandler.replaceFragment(new SessionFragment(), getFragmentManager());
                break;
            case 1:
                fragmentHandler.replaceFragment(new GalleryGridFragment(), getFragmentManager());
                break;
            case 2:
                fragmentHandler.replaceFragment(new SaveSessionFragment(), getFragmentManager());
                break;
            case 3:
                fragmentHandler.replaceFragment(new SettingsFragment(), getFragmentManager());
                break;
            case 4:
                fragmentHandler.replaceFragment(new LogOutFragment(), getFragmentManager());
                break;
            default:
                fragmentHandler.replaceFragment(new SessionFragment(), getFragmentManager());
                break;
        }
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }
}
