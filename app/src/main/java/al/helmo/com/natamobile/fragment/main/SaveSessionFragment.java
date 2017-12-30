package al.helmo.com.natamobile.fragment.main;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;

public class SaveSessionFragment extends Fragment {
    private MainActivity mainActivity;
    private EditText endComment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_save_session, container, false);
        mainActivity = (MainActivity) this.getActivity();
        Button endSession = (Button)view.findViewById(R.id.endSession);
        endComment = (EditText)view.findViewById(R.id.endComment);

        endSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mainActivity.getSessionManager().endSession(endComment.getText().toString(),getActivity());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Fragment fragment = new SessionFragment();
                mainActivity.getFragmentHandler().replaceFragment(fragment, getFragmentManager());
            }
        });
        return view;
    }
}
