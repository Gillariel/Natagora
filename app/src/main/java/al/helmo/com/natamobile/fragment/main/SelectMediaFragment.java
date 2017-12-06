package al.helmo.com.natamobile.fragment.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import al.helmo.com.natamobile.R;
import al.helmo.com.natamobile.fragment.FragmentHandler;

import static android.app.Activity.RESULT_OK;

public class SelectMediaFragment extends Fragment {

    private static final int CAPTURE_IMAGE_FRAGMENT_REQUEST_CODE = 1;
    private static final int CAPTURE_VIDEO_FRAGMENT_REQUEST_CODE = 2;
    private static final int CAPTURE_AUDIO_FRAGMENT_REQUEST_CODE = 3;
    private static final int MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE = 4 ;

    private Button photoButton, cameraButton,audioButton,commentButton ;
    private FragmentHandler fragmentHandler;
    private View view;
    private File pathFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_media,container,false);

        photoButton = (Button)view.findViewById(R.id.photoButton);
        cameraButton = (Button)view.findViewById(R.id.cameraButton);
        audioButton = (Button)view.findViewById(R.id.audioButton);
        commentButton = (Button)view.findViewById(R.id.commentButton);
        fragmentHandler = new FragmentHandler();
        requestPermission();

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(takePicture.resolveActivity(getActivity().getPackageManager()) != null){
                    try {
                        pathFile = createImageFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    startActivityForResult(takePicture, CAPTURE_IMAGE_FRAGMENT_REQUEST_CODE);
                }
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takeVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                takeVideo.putExtra("android.intent.extra.durationLimit", 10);
                if(takeVideo.resolveActivity(getActivity().getPackageManager())!= null){
                    startActivityForResult(takeVideo, CAPTURE_VIDEO_FRAGMENT_REQUEST_CODE);
                }
            }
        });

        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takeSound = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);

                if(takeSound.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivityForResult(takeSound,CAPTURE_AUDIO_FRAGMENT_REQUEST_CODE);
                }
            }
        });

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentMediaFragment fragment = new CommentMediaFragment();
                Bitmap icon =  BitmapFactory.decodeResource(getResources(), R.mipmap.ic_comment);
                fragment.setBitMap(icon);
                fragmentHandler.replaceFragment(new CommentMediaFragment(), getFragmentManager());
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == CAPTURE_IMAGE_FRAGMENT_REQUEST_CODE && resultCode == RESULT_OK){

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            OutputStream outStream = null;
            try {
                outStream = new FileOutputStream(pathFile);
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                outStream.flush();
                outStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CommentMediaFragment fragment = new CommentMediaFragment();
            fragment.setBitMap(imageBitmap);
            fragment.setLocalURI(pathFile);
            fragment.setMediaType("photo");

            fragmentHandler.replaceFragment(fragment,getFragmentManager() );

        }else if (requestCode == CAPTURE_VIDEO_FRAGMENT_REQUEST_CODE && resultCode == RESULT_OK){
            Uri video = data.getData();
            String path = getRealPathFromURI(video);
            CommentMediaFragment fragment = new CommentMediaFragment();
            Bitmap icon =  BitmapFactory.decodeResource(getResources(), R.mipmap.ic_video);
            fragment.setBitMap(icon);
            fragment.setLocalURI(new File(path));
            fragment.setMediaType("video");

            fragmentHandler.replaceFragment(fragment,getFragmentManager() );

        }else if (requestCode == CAPTURE_AUDIO_FRAGMENT_REQUEST_CODE && resultCode == RESULT_OK){
            Uri audio = data.getData();
            String path = getRealPathFromURI(audio);

            CommentMediaFragment fragment = new CommentMediaFragment();

            Bitmap icon =  BitmapFactory.decodeResource(getResources(), R.mipmap.ic_comment);
            fragment.setBitMap(icon);
            fragment.setLocalURI(new File(path));
            fragment.setMediaType("audio");

            fragmentHandler.replaceFragment(fragment,getFragmentManager() );
        }
    }

    private File createImageFile() throws IOException {
        File storageDir = Environment.getExternalStorageDirectory();
        File image = File.createTempFile("example", ".png", storageDir);
        return image;
    }

    private void requestPermission(){
        if (ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE);
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if(cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
}