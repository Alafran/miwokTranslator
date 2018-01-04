package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi","red"));
        colors.add(new Word("chokokki", "green"));
        colors.add(new Word("ṭakaakki", "brown"));
        colors.add(new Word("ṭopoppi", "gray"));
        colors.add(new Word("kululli", "black"));
        colors.add(new Word("kelelli", "white"));
        colors.add(new Word("ṭopiisә", "dusty yellow"));
        colors.add(new Word("chiwiiṭә", "mustard yellow"));


        WordAdapter itemsAdapter = new WordAdapter(this, colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }

}
