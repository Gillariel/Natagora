package al.helmo.com.natamobile.fragment.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.util.GPS;
import static al.helmo.com.natamobile.R.mipmap.ic_start;
import static al.helmo.com.natamobile.R.mipmap.ic_stop;

public class SessionFragment extends Fragment {
    private MainActivity mainActivity;
    private Button startStopButton, newObservation;
    private static final int REQUEST_FINE_LOCATION= 5;
    private static final int REQUEST_COARSE_LOCATION= 6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session,container,false);
        startStopButton = (Button) view.findViewById(R.id.startStopSession);
        newObservation = (Button) view.findViewById(R.id.newObservation);
        mainActivity = (MainActivity) this.getActivity();

        if(!mainActivity.getSessionManager().getStatus()){
            startStopButton.setBackgroundResource(ic_start);
            newObservation.setVisibility(View.INVISIBLE);
        }else{
            startStopButton.setBackgroundResource(ic_stop);
            newObservation.setVisibility(View.VISIBLE);
        }

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mainActivity.getSessionManager().getStatus()){
                    if((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) &&
                            (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED)) {
                        GPS gps = new GPS(getActivity());
                        mainActivity.getSessionManager().startNewSession(gps.getLocation().getLatitude(), gps.getLocation().getLongitude());
                        startStopButton.setBackgroundResource(ic_stop);
                        newObservation.setVisibility(View.VISIBLE);
                    }else{
                        checkPermission();
                    }
                }else{
                Fragment fragment = new SaveSessionFragment();
                mainActivity.getFragmentHandler().replaceFragment(fragment,getFragmentManager());
                }
            }
        });

        newObservation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mainActivity.getSessionManager().getStatus() == true) {
                    Fragment newObservation = new SelectMediaFragment();
                    mainActivity.getFragmentHandler().replaceFragment(newObservation, getFragmentManager());
                }else{
                    Toast.makeText(getActivity(), "The Session is not started", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public void checkPermission(){
        if((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) ||
                (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_LOCATION);
        }
    }
}