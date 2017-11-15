package al.helmo.com.natamobile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.fragment.FragmentMySession;
import al.helmo.com.natamobile.fragment.FragmentSessionPhoto;
import al.helmo.com.natamobile.res.ItemSlideMenu;
import al.helmo.com.natamobile.res.MenuBurgerAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;
    private List<ItemSlideMenu> listMenu;
    private MenuBurgerAdapter adapter;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

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

        listView = (ListView)findViewById(R.id.menuBurger);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        listMenu = new ArrayList<>();
        listMenu.add(new ItemSlideMenu("My Session"));
        listMenu.add(new ItemSlideMenu("My Photos"));
        adapter = new MenuBurgerAdapter(this, listMenu);
        listView.setAdapter(adapter);
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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
        Fragment fragment;
        switch (i){
            case 0:
                fragment = new FragmentMySession();
                break;
            case 1:
                fragment = new FragmentSessionPhoto();
                break;    
            default:
                fragment = new FragmentMySession();
                break;
        }
        if(null!= fragment){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.mainContent, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    } 

}
