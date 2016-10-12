package com.vijayhiremath.permissions.permissions;

import android.content.Context;

/**
 * Created by vijay.hiremath on 07/10/16.
 */
public class PermissionFactory
{
    Context context;

    public static final int CameraPermission              = 1 ;
    public static final int LocationPermission            = 2 ;
    public static final int ReadExternalStoragePermission = 3 ;


    public PermissionFactory(Context context)
    {
        this.context = context;
    }

    public RequestPermission getPermission( int flag  )
    {
        switch ( flag )
        {
            case CameraPermission : return new CameraPermission( context ) ;

            case LocationPermission : return new LocationPermission( context );

            case ReadExternalStoragePermission :return new ReadExternalStoragePermission( context );
        }

        return null;
    }
}
