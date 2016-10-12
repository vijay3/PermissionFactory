package com.vijayhiremath.permissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vijayhiremath.permissions.permissions.CameraPermission;
import com.vijayhiremath.permissions.permissions.LocationPermission;
import com.vijayhiremath.permissions.permissions.PermissionFactory;
import com.vijayhiremath.permissions.permissions.ReadExternalStoragePermission;

public class MainActivity extends AppCompatActivity
{
    String TAG = MainActivity.class.getSimpleName();

    TextView tv_permission_reason;

    CameraPermission cameraPermission;
    LocationPermission locationPermission;
    ReadExternalStoragePermission readExternalStoragePermission;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_permission_reason = ( TextView ) findViewById( R.id.tv_permission_reason );

        /*****************************************************
         * Permission Factory init
         ****************************************************/
        PermissionFactory factory = new PermissionFactory( this );

        cameraPermission              = ( CameraPermission ) factory.getPermission( PermissionFactory.CameraPermission );
        locationPermission            = (LocationPermission) factory.getPermission( PermissionFactory.LocationPermission );
        readExternalStoragePermission = (ReadExternalStoragePermission) factory.getPermission( PermissionFactory.ReadExternalStoragePermission );


        if( !cameraPermission.isAllowed() )
        {
            cameraPermission.requestPermission( this );
        }
        else
        {
            Log.e( TAG , "camera permission is given." ) ;
        }
        /****************************************************/
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == cameraPermission.getRequestCode() )
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                ImageView iv_one = (ImageView) findViewById(R.id.iv_one);
                iv_one.setImageDrawable(getResources().getDrawable(R.drawable.ic_circle_off));

                if( !locationPermission.isAllowed() )
                {
                    locationPermission.requestPermission( this );
                }
                else
                {
                    if( !readExternalStoragePermission.isAllowed() )
                    {
                        readExternalStoragePermission.requestPermission( this );
                    }
                    else
                    {

                    }
                }
            }
            else
            {
                Toast.makeText( this , "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
        else if( requestCode == locationPermission.getRequestCode() )
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                ImageView iv_two = (ImageView) findViewById(R.id.iv_two);
                iv_two.setImageDrawable(getResources().getDrawable(R.drawable.ic_circle_off));

                if( !readExternalStoragePermission.isAllowed() )
                {
                    readExternalStoragePermission.requestPermission( this );
                }
                else
                {

                }
            }
            else
            {
                Toast.makeText( this , "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
        else if( requestCode == readExternalStoragePermission.getRequestCode() )
        {
            if( grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED )
            {
                ImageView iv_three = (ImageView) findViewById(R.id.iv_three);
                iv_three.setImageDrawable(getResources().getDrawable(R.drawable.ic_circle_off));
                Toast.makeText( this , "All permission granted. All set!" , Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText( this , "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
