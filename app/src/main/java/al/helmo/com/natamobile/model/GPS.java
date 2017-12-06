package al.helmo.com.natamobile.model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

public class GPS {

    private Activity context;
    private Location location;
    private LocationManager locationManager;
    private String provider = LocationManager.GPS_PROVIDER;
    private static final int REQUEST_FINE_LOCATION= 5;
    private static final int REQUEST_COARSE_LOCATION= 6;

    public GPS(Activity activity){
        this.context = activity;

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if((ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) ||
                (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)){
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION);
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_LOCATION);
        }

        if((ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED)) {
            location = locationManager.getLastKnownLocation(provider);
        }
    }

    public Location getLocation(){
        return this.location;
    }
}
