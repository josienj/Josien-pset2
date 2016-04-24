package com.example.josien.josien_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Activity_FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
    }

    public void startGame(View view) {

        Intent secondScreen = new Intent(this, Activity_ListView.class);

        secondScreen.putExtra("choose_screen", 500);
        startActivity(secondScreen);
    }
}
