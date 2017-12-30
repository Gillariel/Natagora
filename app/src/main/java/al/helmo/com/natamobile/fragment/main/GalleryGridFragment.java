package al.helmo.com.natamobile.fragment.main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.app.Fragment;
/*import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;*/
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.res.GridAdapter;
import al.helmo.com.natamobile.model.res.GridCell;

public class GalleryGridFragment extends Fragment {

    private MainActivity mainActivity;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gallery_grid,container,false);
        mainActivity = (MainActivity) this.getActivity();

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.gridGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext().getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<GridCell> createLists = prepareData();
        GridAdapter adapter = new GridAdapter(view.getContext().getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private ArrayList<GridCell> prepareData() {
        ArrayList<GridCell> result = new ArrayList<>();

        for(int i = 0; i < mainActivity.getSessionManager().getObservations().size(); i++){
            if(mainActivity.getSessionManager().getObservations().get(i).getMediaType().getType()!="Text") {
                GridCell gridCell = new GridCell();
                Bitmap bitmap;
                if(mainActivity.getSessionManager().getObservations().get(i).getMediaType().getType()=="Photo"){
                    bitmap = BitmapFactory.decodeFile(mainActivity.getSessionManager().getObservations().get(i).getLocalFile().getPath());
                }else if(mainActivity.getSessionManager().getObservations().get(i).getMediaType().getType()=="Video"){
                    bitmap = ThumbnailUtils.createVideoThumbnail(mainActivity.getSessionManager().getObservations().get(i).getLocalFile().getPath(),MediaStore.Images.Thumbnails.MINI_KIND);
                }else {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_sound);
                }
                gridCell.setBitmap(bitmap);
                result.add(gridCell);
            }
        }
        return result;
    }
}
