package al.helmo.com.natamobile.fragment.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.LoginActivity;
import al.helmo.com.natamobile.activity.MainActivity;

import static android.content.Context.MODE_PRIVATE;

public class LogOutFragment extends Fragment {
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_log_out, container, false);

        mainActivity = (MainActivity) this.getActivity();

        mainActivity.getSessionManager().logout();

        SharedPreferences sp = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.clear();
        ed.commit();

        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
        Toast.makeText(getActivity(), "Good Bye", Toast.LENGTH_SHORT).show();

        return view;
    }
}
