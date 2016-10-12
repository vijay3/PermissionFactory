package com.vijayhiremath.permissions.permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by vijay.hiremath on 07/10/16.
 */
public class LocationPermission implements RequestPermission
{
    String TAG = LocationPermission.class.getSimpleName();
    public final int REQUEST_CODE = 1;
    Context context;

    public LocationPermission(Context context)
    {
        this.context = context;
    }

    @Override
    public boolean isAllowed()
    {
        int result = ContextCompat.checkSelfPermission( context , Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }

        return false;
    }

    @Override
    public void requestPermission( Activity activity )
    {
        if( ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION) )
        {
            Log.e( TAG , "Explain why the app needs this permission. Location. User has already denied permission" );
        }

        ActivityCompat.requestPermissions( activity , new String[] { Manifest.permission.ACCESS_FINE_LOCATION } , REQUEST_CODE );
    }

    public int getRequestCode()
    {
        return REQUEST_CODE;
    }
}
