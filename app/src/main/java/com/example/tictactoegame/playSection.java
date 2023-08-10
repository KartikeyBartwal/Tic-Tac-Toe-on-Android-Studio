package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class playSection extends AppCompatActivity {
    TextView statusBar;
    Button goToHome;
    Button resetButton;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;


    int activePlayer = 1;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winStates = {
            {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
    };
    boolean morePlaying = true;

public void playerTapped(View view) {
        TextView statusBar = (TextView)findViewById(R.id.statusBar);
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(morePlaying == true){
      if(gameState[tappedImage]==2){

        if (activePlayer == 1){
            img.setImageResource(R.drawable.cross_final);
            activePlayer = 0;
            gameState[tappedImage]=1;
            statusBar.setText("Second Player's Turn");
        }else {
            img.setImageResource(R.drawable.zero);
            activePlayer = 1;
            gameState[tappedImage] = 0;
            statusBar.setText("First Player's Turn");

        }}else{
        ;
        }}else{
            ;
        }
    //For finding out the winner
    for(int[] winSituation : winStates){

        if(gameState[winSituation[0]] == gameState[winSituation[1]] &&
                gameState[winSituation[1]] == gameState[winSituation[2]]&& gameState[winSituation[0]] == gameState[winSituation[2]] &&
                gameState[winSituation[0]] != 2 && gameState[winSituation[1]] != 2 && gameState[winSituation[2]] != 2) {
//            If 1 i.e X player has won, player 1 has won
            if(gameState[winSituation[0]] == 1 && gameState[winSituation[1]] == 1 &&
                    gameState[winSituation[2]] == 1){
                MediaPlayer mediaPlayer =  MediaPlayer.create(playSection.this,R.raw.victorymusic);
                mediaPlayer.start();
                statusBar.setText("Player 1 Has Won!!!");
                 morePlaying = false;
            }else if (gameState[winSituation[0]] == 0 && gameState[winSituation[1]] == 0 &&
                    gameState[winSituation[2]] == 0){
                MediaPlayer mediaPlayer =  MediaPlayer.create(playSection.this,R.raw.victorymusic);
                mediaPlayer.start();
                statusBar.setText("Player 2 Has Won!!!");
                morePlaying = false;
            }else{
                statusBar.setText("Something's wrong...");
            }
        }
    }
}
public void reset(View view){
    ImageView imageView1 = (ImageView) findViewById(R.id.button1);
    ImageView imageView2 = (ImageView) findViewById(R.id.button2);
    ImageView imageView3 = (ImageView) findViewById(R.id.button3);
    ImageView imageView4 = (ImageView) findViewById(R.id.button4);
    ImageView imageView5 = (ImageView) findViewById(R.id.button5);
    ImageView imageView6 = (ImageView) findViewById(R.id.button6);
    ImageView imageView7 = (ImageView) findViewById(R.id.button7);
    ImageView imageView8 = (ImageView) findViewById(R.id.button8);
    ImageView imageView9 = (ImageView) findViewById(R.id.button9);
    imageView1.setImageResource(R.drawable.background_fake);
    imageView2.setImageResource(R.drawable.background_fake);
    imageView3.setImageResource(R.drawable.background_fake);
    imageView4.setImageResource(R.drawable.background_fake);
    imageView5.setImageResource(R.drawable.background_fake);
    imageView6.setImageResource(R.drawable.background_fake);
    imageView7.setImageResource(R.drawable.background_fake);
    imageView8.setImageResource(R.drawable.background_fake);
    imageView9.setImageResource(R.drawable.background_fake);
    int activePlayer = 1;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean morePlaying = true;
}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_section);

        goToHome = findViewById(R.id.goToHome);



 //                Play Music
        MediaPlayer mediaPlayerPlayArea = MediaPlayer.create(playSection.this,R.raw.playareamusic);
        mediaPlayerPlayArea.start();
        mediaPlayerPlayArea.setLooping(true);
//        Going for all possible win situations
//        0 - O, 1- X, 2 - empty

        goToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayerPlayArea.stop();
                Intent intent = new Intent(playSection.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
