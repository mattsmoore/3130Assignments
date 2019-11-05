/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

// Main class for displaying UI components


public class MainActivity extends AppCompatActivity implements IStateListener {

    private MediaPlayer mediaPlayer;
    public Context context = this;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Get image view
        imageView = findViewById(R.id.imageView2);
        imageView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        // Flashing lights in the game
        Toast toast = Toast.makeText(getApplicationContext(),
                "*** EPILEPSY WARNING ***",
                Toast.LENGTH_LONG);
        toast.show();

        // Start a state listener
        ScaryBunnyGame.getInstance().registerStateListener(this);

        // On click update the image and audio
        imageView.setImageResource(ScaryBunnyGame.getInstance().nextImg());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaryBunnyGame.getInstance().nextImg();
                update();
            }
        });
    }

    // method for updating the image displayed and the mediaplayer

    public void update() {

        // if the media player is active (In scary state), release it
        if(mediaPlayer!=null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // Set all animations to be off
        imageView.setAnimation(null);

        // Set the image resource
        imageView.setImageResource(ScaryBunnyGame.getInstance().currentState.getResourceID());

        // set the audio ID
        int audioID = ScaryBunnyGame.getInstance().currentState.getAudioID();

        // If the audio ID is not zero (which cute bunny state returns) start the player
        // as well as animations
        if(audioID!=0) {
            mediaPlayer = MediaPlayer.create(context,audioID);
            mediaPlayer.start();
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
