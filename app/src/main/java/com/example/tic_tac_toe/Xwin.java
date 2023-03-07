package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Xwin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xwin);


        LottieAnimationView anim = findViewById(R.id.congratsx);
        anim.setAnimation("congratulations.json");
        anim.playAnimation();

        TextView message = findViewById(R.id.messagex);



        Button reset = findViewById(R.id.x_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Xwin.this,GamePage.class);
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
                String text = "Player - 'X' has won";
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