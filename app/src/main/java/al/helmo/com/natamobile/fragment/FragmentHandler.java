package al.helmo.com.natamobile.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import al.helmo.com.natamobile.R;

public class FragmentHandler {

    public void replaceFragment(Fragment fragment, FragmentManager mainActivity){
        FragmentManager fragmentManager = mainActivity;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceLogFragment(Fragment fragment, FragmentManager mainActivity){
        FragmentManager fragmentManager = mainActivity;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContentLog,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
