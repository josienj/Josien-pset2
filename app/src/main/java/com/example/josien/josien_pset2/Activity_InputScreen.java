package com.example.josien.josien_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class Activity_InputScreen extends Activity {

/* Declare some variables */
private Story parser;
private InputStream stream;
private TextView categoryView;
private TextView wordLeftView;
private EditText textInput;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);

        /* Initialize widgets */
        categoryView = (TextView) findViewById(R.id.category);
        wordLeftView = (TextView) findViewById(R.id.words_left);
        textInput = (EditText) findViewById(R.id.word_input);

        /* Send inputStream to parser. */
        parseStream(stream);
        }

    /* onSave & onRestore take care of correct screen rotation */
@Override
public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putSerializable("parser", parser);
        }

@Override
public void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);

        parser = (Story) inState.getSerializable("parser");
        int receivedId = inState.getInt("buttonId");

        resetViews();
        categoryView.append(" " + parser.getNextPlaceholder());
        wordLeftView.append(" " + parser.getPlaceholderRemainingCount());
        }

    /* Object called when a word is entered */
public void enterWord(View view) {

        /* Takes care of the remaining words that has to be filled in */
        int remaining;

        /* Store input */
        String input = String.valueOf(textInput.getText());
        textInput.setText("");

        /* Pass input to parser */
        parser.fillInPlaceholder(input);

        /* Get number of remaining placeholders */
        remaining = parser.getPlaceholderRemainingCount();

        /* When everything is filled in, move on to next screen */
        if (remaining == 0) {

final int result = 1;
        Intent thirdScreen = new Intent(this, Activity_LastScreen.class);
        thirdScreen.putExtra("parser", parser);
        startActivityForResult(thirdScreen, result);
        }

        /* Continuously update category and words_left */
        resetViews();
        categoryView.append(" " + parser.getNextPlaceholder());
        wordLeftView.append(" " + remaining);
        }

    /* Here is where I lost it. First I started with RadioButtons to complete this assignment,
    then you could use this way to compare the texts and decide what story you have chosen. But,
    after a couple of days, I started with making a ListView and add another screen. Which I created
    in strings.xml and try to work further with. Unfortunately, it has not worked out well and in
    the end I get more and more errors... So, I decided to turn this back on, although it totally
    not work this way since I have no Buttons anymore. I have tried and read a lot about it for
    two days but I don't get it. So I know that this don't work at all, but when I had the buttons,
    my code worked till the end, so I have that code but can't test it anymore because of the errors

    public void selectStory(View view) {

        if (buttonText.toString().equals("Simple")) {
            stream = this.getResources().openRawResource(R.raw.madlib0_simple);
        } else if (buttonText.toString().equals("Tarzan")) {
            stream = this.getResources().openRawResource(R.raw.madlib1_tarzan);
        } else if (buttonText.toString().equals("University")) {
            stream = this.getResources().openRawResource(R.raw.madlib2_university);
        } else if (buttonText.toString().equals("Clothes")) {
            stream = this.getResources().openRawResource(R.raw.madlib3_clothes);
        } else {
            stream = this.getResources().openRawResource(R.raw.madlib4_dance);
        }
        parseStream(stream);
    }

    /* Method to pass Stream to story */
public void parseStream(InputStream stream) {

        /* Create a new story and show placeholder information */
        try {
        parser = new Story(stream);
        categoryView.append(" " + parser.getNextPlaceholder());
        wordLeftView.append(" " + parser.getPlaceholderCount());
        } catch (Exception e) {
        Toast.makeText(this, " ", Toast.LENGTH_LONG).show();
        }
}

    /* How to reset the Views */
public void resetViews() {
        categoryView.setText(R.string.category);
        wordLeftView.setText(R.string.words_left);
        }
}
