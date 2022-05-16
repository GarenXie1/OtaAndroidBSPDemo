package com.garen.otahr40;


import android.content.Context;
import android.os.RecoverySystem;
import android.util.Log;

import java.io.File;

public class OtaHr40 {
    private static final String TAG = "OtaHr40";
    private static Context mContext = null;

    public OtaHr40(Context context){
        mContext = context;
    }

    public void otaUpdate(){
        String path = "/data/media/0/OTA-HR40.EV.v7.20220511.1109.zip";
        File otafile = new File(path);
        if(!otafile.exists()){
            Log.d(TAG,"not exist");

        }else {
            Log.d(TAG,"exist");
            try {

                RecoverySystem.verifyPackage(otafile, null, null);
                Log.d(TAG, "Successfuly verified ota package.");
            }
            catch (Exception e) {
                Log.e(TAG, "Corrupted package: " + e);
                e.printStackTrace();
            }

            try {
                RecoverySystem.installPackage(mContext, otafile);
            }
            catch (Exception e) {
                Log.e(TAG, "Error while install OTA package: " + e);
                Log.e(TAG, "Will retry download");
                e.printStackTrace();
            }
        }
    }
}
