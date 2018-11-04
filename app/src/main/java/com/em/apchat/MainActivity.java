package com.em.apchat;

import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.em.apchat.Utils.PermissionRequest;
import com.em.apchat.Utils.WifiUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static MainActivity thisActivity;

    public static MainActivity getThisActivity(){ return thisActivity; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisActivity = this;
        WifiUtils.enableWifi();

        if(!PermissionRequest.ifNeedToRequest()){
            if(!PermissionRequest.checkPermission()){
                PermissionRequest.requestPermission();
            }
        }

        WifiUtils.startScan();
        List<ScanResult> scanResults =  WifiUtils.getScanResults();
        for(ScanResult scanResult : scanResults){
            Log.d(TAG, "onCreate: SSID:" + scanResult.SSID + " BSSID:" + scanResult.BSSID);
        }

    }
}
