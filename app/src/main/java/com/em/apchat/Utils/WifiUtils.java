package com.em.apchat.Utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.em.apchat.MainActivity;

import java.util.HashSet;
import java.util.List;

public class WifiUtils {
    private static final String TAG = "WifiUtils";
    private static Context context = MainActivity.getThisActivity().getApplicationContext();
    private static WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
    private static final String BLANKSSID = "";

    public static boolean isWifiEnabled(){
        return wifiManager.isWifiEnabled();
    }

    public static void enableWifi(){
        wifiManager.setWifiEnabled(true);
    }

    public static void disableWifi(){
        wifiManager.setWifiEnabled(false);
    }

    public static void startScan(){
        wifiManager.startScan();
    }

    public static List<ScanResult> getScanResults(){
        List<ScanResult> scanResults = wifiManager.getScanResults();
        filter(scanResults);
        return scanResults;
    }

    private static void filter(List<ScanResult> scanResults){
        for(int i = 0; i < scanResults.size(); ++i){
            if(scanResults.get(i).SSID == BLANKSSID) {
                scanResults.remove(i);
            }
        }
        HashSet hashSet = new HashSet(scanResults);
        scanResults.clear();
        scanResults.addAll(hashSet);
        /*scanResults.clear();
        for(ScanResult scanResult : scanResultCopy){
            if(Collections.frequency(scanResults, scanResult) < 1){
                scanResults.add(scanResult);
            }
        }*/
    }
}
