package al.helmo.com.natamobile.fragment.main;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.fragment.FragmentHandler;

import static al.helmo.com.natamobile.R.mipmap.ic_start;
import static al.helmo.com.natamobile.R.mipmap.ic_stop;

public class SessionFragment extends Fragment {
    private FragmentHandler fragmentHandler;
    private MainActivity mainActivity;
    private Button startStopButton, newObservation;

    public SessionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session,container,false);
        startStopButton = (Button) view.findViewById(R.id.startStopSession);
        newObservation = (Button) view.findViewById(R.id.newObservation);
        fragmentHandler = new FragmentHandler();
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
                    // need to check GPS information to get latitude and longitude
                    mainActivity.getSessionManager().startNewSession(0, 0);
                    startStopButton.setBackgroundResource(ic_stop);
                    newObservation.setVisibility(View.VISIBLE);
                }else{
                    mainActivity.getSessionManager().endSession();
                    mainActivity.getSessionManager().deleteAllMedia();
                    startStopButton.setBackgroundResource(ic_start);
                    newObservation.setVisibility(View.INVISIBLE);
                }
            }
        });

        newObservation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Fragment newObservation = new SelectMediaFragment();
                fragmentHandler.replaceFragment(newObservation, getFragmentManager());
            }
        });
        return view;
    }
}