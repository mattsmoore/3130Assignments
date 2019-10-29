package com.example.scarybunny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.imageView2);
        imageView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        imageView.setImageResource(ScaryBunnyGame.getInstance().nextImg());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                imageView.setAnimation(null);
                imageView.setImageResource(ScaryBunnyGame.getInstance().nextImg());
                int audioID = ScaryBunnyGame.getInstance().currentState.getAudioID();
                if(audioID!=0) {
                    mediaPlayer = MediaPlayer.create(context,audioID);
                    mediaPlayer.start();
                }
                if(ScaryBunnyGame.getInstance().currentState.returnType() == 0){
                    final Animation animShake = AnimationUtils.loadAnimation(context, R.anim.shake);
                    imageView.setAnimation(animShake);
                }

            }
        });
    }
}
