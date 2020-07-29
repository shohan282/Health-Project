package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.healthcare.databinding.ActivityBloodSignUpBinding;


public class BloodSignUp extends AppCompatActivity {

    ActivityBloodSignUpBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityBloodSignUpBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        VideoStart();

    }

     void VideoStart(){

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.v);
        b.videoView.setVideoURI(uri);
        b.videoView.start();

        b.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                b.videoView.start();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        VideoStart();

    }

}