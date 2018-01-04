
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //all of the main TextViews in the XML file
        TextView numbersTextView = (TextView) findViewById(R.id.numbers_textview);
        TextView colorsTextView = (TextView) findViewById(R.id.colors_textview);
        TextView familyTextView = (TextView) findViewById(R.id.family_textview);
        TextView phrasesTextView = (TextView) findViewById(R.id.phrases_textview);

        //Opens the NumbersActivity.java class when clicked
        numbersTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openNumbersList = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(openNumbersList);
            }
        });

        //Opens the ColorsActivity.java class when clicked
        colorsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openColorsList = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(openColorsList);
            }
        });

        //Opens the FamilyMembersActivity.java class when clicked
        familyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openFamiliyList = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(openFamiliyList);
            }
        });

        //opens the PhrasesActivity.java class when clicked
        phrasesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPhrasesList = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(openPhrasesList);
            }
        });

    }
}
