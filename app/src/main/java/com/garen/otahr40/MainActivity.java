package com.garen.otahr40;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button otaButton = findViewById(R.id.Get_OTA_packet);
        otaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Will get HR40 OTA packet");

                Context context = getApplicationContext();
                OtaHr40 ota = new OtaHr40(context);

                TcpClient tcpClient = new TcpClient(ota);
                new Thread(tcpClient).start();

            }
        });
    }
}