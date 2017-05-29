package com.example.sumal.morse_code_android_application;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.reflect.Array;
import java.security.Policy;
import java.util.Timer;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private Button button_send;
    private Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    private Parameters params;
    private MediaPlayer mp;
    private Timer timer ;
    private EditText editText_msg ;
    private String get_text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_send = (Button) findViewById(R.id.button_send);

        // check Camera Flash Available

        hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(!hasFlash){

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("You Need Camera Flash Light");
            builder1.setMessage("Run This Application On Real Device ! A Device Has Flash Light");
            builder1.setCancelable(true);

            builder1.setPositiveButton("Continue Anyway",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            builder1.setNegativeButton("Close Application",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(1);
                        }
                    });

            AlertDialog alert1 = builder1.create();
            alert1.show();

        }

    }




    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (RuntimeException e) {
                Log.e("Camera Error",e.getMessage());
            }
        }
    }

    private void turnOnFlash() {

        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();

    }

    private void turnOffFlash() {

        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.startPreview();

    }



}
