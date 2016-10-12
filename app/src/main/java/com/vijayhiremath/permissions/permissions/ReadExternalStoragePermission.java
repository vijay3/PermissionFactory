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
public class ReadExternalStoragePermission implements RequestPermission
{
    String TAG = ReadExternalStoragePermission.class.getSimpleName();
    Context context;
    public final int REQUEST_CODE = 3;

    public ReadExternalStoragePermission(Context context)
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
    public void requestPermission(Activity activity)
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale( activity, Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            Log.e(TAG, "Explain why the app needs this permission external storage. (User has already denied permission)");
        }

        ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE } , REQUEST_CODE );
    }

    public int getRequestCode()
    {
        return REQUEST_CODE;
    }
}
