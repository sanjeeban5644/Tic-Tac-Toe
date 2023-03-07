package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Owin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owin);


        LottieAnimationView anim = findViewById(R.id.congrats);


        anim.setAnimation("congratulations.json");
        anim.playAnimation();

        TextView message = findViewById(R.id.messageo);

        Button reset = findViewById(R.id.o_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Owin.this,GamePage.class);
                startActivity(intent);
            }
        });



        anim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animator) {
                String msg = "Congratulations";
                message.setText(msg);
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animator) {

                String text = "Player - 'O' has won";
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