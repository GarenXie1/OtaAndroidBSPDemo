package com.garen.otahr40;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 升级 HR40 BSP 固件.
        Context context = getApplicationContext();
        OtaHr40 ota = new OtaHr40(context);
        ota.otaUpdate();
    }
}