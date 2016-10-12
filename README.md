# PermissionFactory
Android permission with factory pattern design.

Code stub :

/********************************************************/

PermissionFactory factory = new PermissionFactory( this );

CameraPermission cameraPermission = ( CameraPermission ) factory.getPermission( PermissionFactory.CameraPermission );

if( !cameraPermission.isAllowed() )

{

      cameraPermission.requestPermission( this );

}

else


{


      Log.e( TAG , "camera permission is given." ) ;
      
}


/********************************************************/
