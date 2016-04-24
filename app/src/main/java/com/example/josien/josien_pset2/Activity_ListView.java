package com.example.josien.josien_pset2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Josien on 23-4-2016.
 */


public class Activity_ListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Store the string into an array */
        final String[] stories = getResources().getStringArray(R.array.stories);
        /* Make order random */
        String randomStr = stories[new Random().nextInt(stories.length)];

        /* Set the Array into ListAdapter */
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_choose_screen, R.id.textview, stories));

        ListView lv = getListView();

        /* Listening to single list item on click */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                /* Selected item */
                String story = ((TextView) view).getText().toString();

                /* When clicked on a item, go to next screen */
                Intent inputScreen = new Intent(getApplicationContext(), Activity_InputScreen.class);

                inputScreen.putExtra("stories", stories);
                startActivity(inputScreen);
            }
        });
    }
}