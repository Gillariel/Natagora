package al.helmo.com.natamobile.model.res;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import al.helmo.com.natamobile.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private ArrayList<GridCell> galleryList;
    private Context context;

    public GridAdapter(Context context, ArrayList<GridCell> galleryList){
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery_grid,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GridAdapter.ViewHolder viewHolder, int i){
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmap = galleryList.get(i).getBitmap();
        viewHolder.img.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount(){
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgItemGrid);

        }
    }
}
