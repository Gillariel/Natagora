package al.helmo.com.natamobile.fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import al.helmo.com.natamobile.R;

public class FragmentMySession extends Fragment {

    public FragmentMySession() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mysession, container, false);
        return rootView;
    }
}
