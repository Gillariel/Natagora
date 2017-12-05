package al.helmo.com.natamobile.fragment.main;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import al.helmo.com.natamobile.R;


public class SaveSessionFragment extends Fragment {


    public SaveSessionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_session, container, false);
    }

}
