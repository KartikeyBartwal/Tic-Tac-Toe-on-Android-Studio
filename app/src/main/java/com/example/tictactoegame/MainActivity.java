package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView image;
    Button play;
    Button about;
    Button rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        play = findViewById(R.id.play);
        about = findViewById(R.id.about);
        rate = findViewById(R.id.rate);

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.homepagemusic);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        boolean musicState = true;
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(MainActivity.this,playSection.class);
                startActivity(intent);

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutPage.class);
                intent.putExtra("myMusicState",true);
                startActivity(intent);
            }
        });
    }
}