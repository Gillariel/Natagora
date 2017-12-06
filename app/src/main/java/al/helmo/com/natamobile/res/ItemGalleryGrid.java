package al.helmo.com.natamobile.res;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;

public class ItemGalleryGrid {

    private ImageView image;

        public ItemGalleryGrid(File file){
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
            this.image.setImageBitmap(bitmap);
        }
}
