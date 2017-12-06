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
import al.helmo.com.natamobile.fragment.FragmentHandler;
import al.helmo.com.natamobile.model.Media;
import al.helmo.com.natamobile.model.Observation;

public class CommentMediaFragment extends Fragment {

    private Bitmap bitMap;
    private File localURI;
    private String mediaType;
    private MainActivity mainActivity;
    private EditText txtObservationComment;
    private FragmentHandler fragmentHandler;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_media,container,false);

        Button imageButton = (Button) view.findViewById(R.id.mediaImgButton);
        Button nextButton = (Button)view.findViewById(R.id.btnNextComment);
        txtObservationComment = (EditText)view.findViewById(R.id.txtObservationComment);
        Drawable d = new BitmapDrawable(getResources(), bitMap);
        mainActivity = (MainActivity) this.getActivity();
        fragmentHandler = new FragmentHandler();

        imageButton.setBackground(d);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mediaType) {
                    case "photo": {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(localURI.toString()), "image/*");
                        startActivity(intent);
                        break;
                    }
                    case "video": {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(localURI.toString()), "video/*");
                        startActivity(intent);
                        break;
                    }
                    case "audio": {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(localURI.toString()), "video/*");
                        startActivity(intent);
                        break;
                    }
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Media media = new Media(localURI);
                Observation o= new Observation(media, txtObservationComment.getText().toString());
                mainActivity.getSessionManager().addObservation(o);
                Fragment fragment = new SessionFragment();
                fragmentHandler.replaceFragment(fragment, getFragmentManager());
            }
        });
        return view;
    }

    public void setBitMap(Bitmap bitmap){
        this.bitMap = bitmap;
    }

    public void setLocalURI(File localURI) {
        this.localURI = localURI;
    }

    public void setMediaType(String type){this.mediaType = type;}

}
