package com.example.scarybunny;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.media.MediaPlayer;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements IStateListener {

    public static boolean GO;

    private MediaPlayer mediaPlayer;
    public Context context = this;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GO = false;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView2);
        imageView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Toast toast = Toast.makeText(getApplicationContext(),
                "*** EPILEPSY WARNING ***",
                Toast.LENGTH_LONG);
        toast.show();

        ScaryBunnyGame.getInstance().registerStateListener(this);



        imageView.setImageResource(ScaryBunnyGame.getInstance().nextImg());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaryBunnyGame.getInstance().nextImg();
                update();
            }
        });
    }

    public void update() {
        if(mediaPlayer!=null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        imageView.setAnimation(null);
        imageView.setImageResource(ScaryBunnyGame.getInstance().currentState.getResourceID());
        int audioID = ScaryBunnyGame.getInstance().currentState.getAudioID();
        if(audioID!=0) {
            mediaPlayer = MediaPlayer.create(context,audioID);
            mediaPlayer.start();
        }
        if(ScaryBunnyGame.getInstance().currentState.returnType() == 0){
            AnimationSet s = new AnimationSet(false);
            final Animation animation = new AlphaAnimation(1, 0);
            animation.setDuration(1); //1 second duration for each animation cycle
            animation.setInterpolator(new LinearInterpolator());
            animation.setRepeatCount(40); //repeating indefinitely
            animation.setRepeatMode(Animation.REVERSE);
            final Animation animShake = AnimationUtils.loadAnimation(context, R.anim.shake);
            s.addAnimation(animation);
            s.addAnimation(animShake);
            imageView.startAnimation(s);
        }

    }


}
