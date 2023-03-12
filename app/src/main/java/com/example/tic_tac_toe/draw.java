package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class draw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        LottieAnimationView anim = findViewById(R.id.draw_match);
        anim.setAnimation("draw.json");
        anim.playAnimation();

        TextView message = findViewById(R.id.messaged);

        MediaPlayer transition = MediaPlayer.create(this,R.raw.draws);
        try{
            transition.start();

            transition.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    transition.release();
                }
            });
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Media cannot be played",Toast.LENGTH_SHORT).show();
        }




        Button reset = findViewById(R.id.draw_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        anim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {
                String msg = "Match Drawn";
                message.setText(msg);
                Toast.makeText(getApplicationContext(),"Draw",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {
                String text = "Draw Match";
                message.setText(text);

            }

            @Override
            public void onAnimationCancel(@NonNull Animator animator) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animator) {

            }
        });



    }
}