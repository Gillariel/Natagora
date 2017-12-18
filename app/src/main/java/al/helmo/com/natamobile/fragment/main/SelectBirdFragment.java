package al.helmo.com.natamobile.fragment.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.LocalObservation;


public class SelectBirdFragment extends Fragment {

    private LocalObservation localObservation;
    private MainActivity mainActivity;
    private Button nextButton;
    private Spinner primarySpinner, secondarySpinner, lengthSpinner;
    private ListView birdsListView;
    private ArrayAdapter<String> primarySpinnerAdapter, secondarySpinnerAdapter,lengthSpinnerAdapter,birdsListViewAdapter;
    private int selectedBirdId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_bird, container, false);
        nextButton = (Button)view.findViewById(R.id.saveObservation);
        primarySpinner = (Spinner)view.findViewById(R.id.primarySpinner);
        secondarySpinner = (Spinner)view.findViewById(R.id.secondarySpinner);
        lengthSpinner = (Spinner)view.findViewById(R.id.lengthSpinner);
        birdsListView = (ListView)view.findViewById(R.id.birdsListView);
        mainActivity = (MainActivity) this.getActivity();
        setSpinners();
        setBirdList();

        primarySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainActivity.getSessionManager().getBirdsHandler().filterBirds((int)primarySpinner.getSelectedItemId(),(int) secondarySpinner.getSelectedItemId(), (int)lengthSpinner.getSelectedItemId());
                setBirdList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        secondarySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainActivity.getSessionManager().getBirdsHandler().filterBirds((int)primarySpinner.getSelectedItemId(),(int) secondarySpinner.getSelectedItemId(), (int)lengthSpinner.getSelectedItemId());
                setBirdList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainActivity.getSessionManager().getBirdsHandler().filterBirds((int)primarySpinner.getSelectedItemId(),(int) secondarySpinner.getSelectedItemId(), (int)lengthSpinner.getSelectedItemId());
                setBirdList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        birdsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBirdId = (int) birdsListView.getItemIdAtPosition(i);
            }
        });

        birdsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = mainActivity.getSessionManager().getBirdsHandler().getSelectedBird(i).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedBirdId > 0){
                    localObservation.setBird(mainActivity.getSessionManager().getBirdsHandler().getSelectedBird(selectedBirdId));
                    mainActivity.getSessionManager().addObservation(localObservation);
                    mainActivity.getFragmentHandler().replaceFragment(new SessionFragment(), getFragmentManager());
                }else{
                    Toast.makeText(getActivity(), "Select A Bird to continue", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void setBirdList() {
        List<String> listBirds = mainActivity.getSessionManager().getBirdsHandler().getBirdsList();
        birdsListViewAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, listBirds);
        birdsListView.setAdapter(birdsListViewAdapter);
    }

    private void setSpinners() {
        List<String> primaryList = mainActivity.getSessionManager().getBirdsHandler().getPrimaryColorFilter();
        List<String> lengthList = mainActivity.getSessionManager().getBirdsHandler().getLengthFilter();
        primarySpinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, primaryList);
        secondarySpinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, primaryList);
        lengthSpinnerAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item, lengthList);
        primarySpinner.setAdapter(primarySpinnerAdapter);
        secondarySpinner.setAdapter(secondarySpinnerAdapter);
        lengthSpinner.setAdapter(lengthSpinnerAdapter);
    }

    public void setLocalObservation(LocalObservation localObservation) {
        this.localObservation = localObservation;
    }
}