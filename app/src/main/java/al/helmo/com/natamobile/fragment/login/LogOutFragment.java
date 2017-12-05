package al.helmo.com.natamobile.fragment.login;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import al.helmo.com.natamobile.R;

public class LogOutFragment extends Fragment {

    public LogOutFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_out, container, false);
    }
}
