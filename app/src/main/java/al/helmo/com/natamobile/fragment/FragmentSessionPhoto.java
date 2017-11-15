package al.helmo.com.natamobile.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import al.helmo.com.natamobile.R;

public class FragmentSessionPhoto extends Fragment {

    public FragmentSessionPhoto() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sessionphoto, container, false);
        return rootView;
    }

}
