package al.helmo.com.natamobile.fragment.main;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import al.helmo.com.natamobile.R;

public class GalleryGridFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_media,container,false);

        /*RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.gridGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext().getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(view.getContext().getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);*/

        return view;
    }
}
