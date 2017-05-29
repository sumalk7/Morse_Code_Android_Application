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


        // get Access into Camera

        getCamera();

        // implement Button OnClick Listener


        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editText_msg = (EditText) findViewById(R.id.editText_msg);

                get_text = editText_msg.getText().toString();

                char Array_letters[] = get_text.toCharArray();

                for(int i = 0; i < Array_letters.length; i++){

                    morse(Array_letters[i]);

                }


            }
        });


    }


    private void morse(char x){

        switch (x){

            case 'A' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'B' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'C' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'D' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'E' :

                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'F' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'G' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'H' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'I' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'J' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'K' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'L' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'M' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'N' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'O' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'P' :

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'Q' :

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'S':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'T':

                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'U':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'V':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'W':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'X':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'Y':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case 'Z':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '1':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case '2':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case '3':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case '4':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case '5':

                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '6':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '7':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '8':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '9':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_1000();
                sp_letter();// space between letters -> 3 units
                break;

            case '0':

                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                turnOnFlash();
                onPause_3000();
                sp_letter();// space between letters -> 3 units
                break;

            case '.':
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();
                turnOnFlash();
                onPause_1000();

            default:


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

    protected void onPause_1000() {

        super.onPause();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turnOffFlash();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void onPause_3000() {

        super.onPause();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turnOffFlash();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void sp_letter(){

        super.onPause();

        turnOnFlash();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turnOffFlash();
        turnOnFlash();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turnOffFlash();
        turnOnFlash();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turnOffFlash();

    }



}
