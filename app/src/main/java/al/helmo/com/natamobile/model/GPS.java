package al.helmo.com.natamobile.model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

public class GPS {

    private Location location;

    public GPS(Activity activity){

        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        if((ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED)) {
            String provider = LocationManager.GPS_PROVIDER;
            if (locationManager != null) {
                location = locationManager.getLastKnownLocation(provider);
            }
        }
    }

    public Location getLocation(){
        return this.location;
    }
}
