package com.em.apchat.Utils;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.em.apchat.MainActivity;

public class PermissionRequest {
    private static String[] permissionReuqestList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    public static boolean ifNeedToRequest(){
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
    }

    public static boolean checkPermission(){
        int permission = ActivityCompat.checkSelfPermission(MainActivity.getThisActivity().getApplication(), permissionReuqestList[0]);
        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(){
        ActivityCompat.requestPermissions(MainActivity.getThisActivity(), permissionReuqestList, 1);
    }
}
