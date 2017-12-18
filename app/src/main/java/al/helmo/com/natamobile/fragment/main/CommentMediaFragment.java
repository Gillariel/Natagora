package al.helmo.com.natamobile.fragment.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.io.File;
import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.activity.MainActivity;
import al.helmo.com.natamobile.model.Media;
import al.helmo.com.natamobile.model.LocalObservation;

public class CommentMediaFragment extends Fragment {

    private Bitmap bitMap;

    private MainActivity mainActivity;
    private EditText txtObservationComment;
    private LocalObservation localObservation;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_media,container,false);

        Button imageButton = (Button) view.findViewById(R.id.mediaImgButton);
        Button nextButton = (Button)view.findViewById(R.id.btnNextComment);
        txtObservationComment = (EditText)view.findViewById(R.id.txtObservationComment);
        Drawable d = new BitmapDrawable(getResources(), bitMap);

        mainActivity = (MainActivity) this.getActivity();

        imageButton.setBackground(d);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (localObservation.getMediaType().getType()) {
                    case "Photo": {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(localObservation.getLocalFile().toString()), "image/*");
                        startActivity(intent);
                        break;
                    }
                    case "Audio":
                    case "Video": {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(localObservation.getLocalFile().toString()), "video/*");
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localObservation.setComment(txtObservationComment.getText().toString());
                SelectBirdFragment fragment = new SelectBirdFragment();
                fragment.setLocalObservation(localObservation);

                mainActivity.getFragmentHandler().replaceFragment(fragment, getFragmentManager());
            }
        });
        return view;
    }

    public void setBitMap(Bitmap bitmap){
        this.bitMap = bitmap;
    }

    public void setLocalObservation(LocalObservation lo){
        this.localObservation = lo;
    }

}
