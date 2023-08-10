package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AboutPage extends AppCompatActivity {
    EditText AboutText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        AboutText = findViewById(R.id.AboutText);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
          boolean value = bundle.getBoolean("myMusicState");
        }
    }
}