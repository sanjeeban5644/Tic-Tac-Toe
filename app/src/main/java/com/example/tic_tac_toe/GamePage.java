package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GamePage extends AppCompatActivity {



    boolean gameActive=true;

    //0->O
    //1->X
    //2->null
    int activePlayer = 1;

    //Game State
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] winpos = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};


    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the activity here
        for(int i : state){
            if(i!=2){
                recreate();
            }
        }

    }


    public void onTap(View view){
        ImageView img = (ImageView) view;
        int box_tapped = Integer.parseInt(img.getTag().toString());
        if(state[box_tapped]==2){
            state[box_tapped]=activePlayer;
            if(activePlayer==0){
                activePlayer=1;
                img.setImageResource(R.drawable.circle);
                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            }else{
                activePlayer=0;
                img.setImageResource(R.drawable.cross);
                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            }
        }else{
            Toast.makeText(getApplicationContext(),"Box is filled",Toast.LENGTH_SHORT).show();
        }
        boolean flag = false;
        for(int i = 0;i<state.length;i++){
            if(state[i]==2) flag = true;
        }

        if(flag){
            for(int[] win : winpos){
                if(state[win[0]]==state[win[1]] && state[win[1]]==state[win[2]] && state[win[0]]!=2){
                    gameActive=false;
                    if(state[win[0]]==1){
                        //X has won
                        Intent intent = new Intent(GamePage.this,Xwin.class);
                        startActivity(intent);
                        //new section

                        //end of new section
                    }else{
                        //O has won
                        Intent intent = new Intent(GamePage.this,Owin.class);
                        startActivity(intent);
                    }


                }
            }
        }else{
            Intent intent = new Intent(GamePage.this,draw.class);
            startActivity(intent);
        }

        //check for winners





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);


        MediaPlayer transition = MediaPlayer.create(this,R.raw.bell);
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



        TextView status = findViewById(R.id.status);
        status.setText("X's turn");
    }
}