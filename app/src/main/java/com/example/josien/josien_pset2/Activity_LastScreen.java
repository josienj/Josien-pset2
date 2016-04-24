package com.example.josien.josien_pset2;

/**
 * Created by Josien on 19-4-2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_LastScreen extends Activity {

    /* Declare some variables. */
    private Story parser;
    private TextView storyView;
    private String currentStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_screen);

        /* Initialize widget to show and receive parser from inputscreen */
        storyView = (TextView) findViewById(R.id.story_view);
        Intent calledActivity = getIntent();
        parser = (Story) calledActivity.getSerializableExtra("parser");
        currentStory = parser.toString();
        storyView.setText(currentStory);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        /* Pass current story. */
        outState.putString("story", currentStory);

    }

    /* Method called to retrieve data after pausing of activity.
     * Enables correct handling of screen rotation.
     */
    @Override
    public void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);

        /* Retrieve and set current story. */
        currentStory = inState.getString("story");
        storyView.setText(currentStory);
    }
}
