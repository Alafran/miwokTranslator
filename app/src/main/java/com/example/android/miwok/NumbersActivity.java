package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","one"));
        numbers.add(new Word("otiiko", "two"));
        numbers.add(new Word("tolookosu", "three"));
        numbers.add(new Word("oyyisa", "four"));
        numbers.add(new Word("massokka", "five"));
        numbers.add(new Word("temmokka", "six"));
        numbers.add(new Word("kenekaku", "seven"));
        numbers.add(new Word("kawinta", "eight"));
        numbers.add(new Word("wo'e", "nine"));
        numbers.add(new Word("na'aacha", "ten"));

        WordAdapter itemsAdapter = new WordAdapter(this, numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }

}
