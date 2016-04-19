package com.example.josien.josien_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class introscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introscreen);
    }

    public void startGame(View view) {

        Intent secondScreen = new Intent(this, inputscreen.class);

        secondScreen.putExtra("input_screen", 1);
        startActivity(secondScreen);

    }
}
