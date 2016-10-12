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
public class CameraPermission implements RequestPermission
{
    public final int REQUEST_CODE = 2;

    String TAG = CameraPermission.class.getSimpleName();
    Context context;

    public CameraPermission(Context context)
    {
        this.context = context;
    }

    @Override
    public boolean isAllowed()
    {
        int result = ContextCompat.checkSelfPermission( context , Manifest.permission.CAMERA);

        if( result == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }

        return false;
    }

    @Override
    public void requestPermission( Activity activity )
    {
        if( ActivityCompat.shouldShowRequestPermissionRationale( activity , Manifest.permission.CAMERA ) )
        {
            Log.e(TAG, "Explain why the app needs this permission camera. (User has already denied permission)");
        }

        ActivityCompat.requestPermissions( activity , new String[]{Manifest.permission.CAMERA} , REQUEST_CODE );
    }

    public int getRequestCode()
    {
        return REQUEST_CODE;
    }
}
