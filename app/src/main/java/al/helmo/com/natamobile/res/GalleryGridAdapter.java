package al.helmo.com.natamobile.res;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.model.Observation;

public class GalleryGridAdapter extends RecyclerView.Adapter<GalleryGridAdapter.ViewHolder> {

    private Context context;
    private List<ItemGalleryGrid> list;

    public GalleryGridAdapter(Context context, List<Observation> observationList){
        this.context = context;
        buildGrid(observationList);
    }

    private void buildGrid(List<Observation> observationList) {
        list = new ArrayList<>();
        for (Observation o :observationList) {
            list.add(new ItemGalleryGrid(o.getMediaLocalUri()));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }
}
