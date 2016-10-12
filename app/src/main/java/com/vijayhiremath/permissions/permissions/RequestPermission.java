package com.vijayhiremath.permissions.permissions;

import android.app.Activity;

/**
 * Created by vijay.hiremath on 07/10/16.
 */
public interface RequestPermission
{
    public boolean isAllowed();
    public void    requestPermission( Activity activity );
}
