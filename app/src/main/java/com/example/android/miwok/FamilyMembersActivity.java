package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ArrayList<Word> familyMembers = new ArrayList<>();
        familyMembers.add(new Word("әpә","father"));
        familyMembers.add(new Word("әṭa", "mother"));
        familyMembers.add(new Word("angsi", "son"));
        familyMembers.add(new Word("tune", "daughter"));
        familyMembers.add(new Word("taachi", "older brother"));
        familyMembers.add(new Word("chalitti", "younger brother"));
        familyMembers.add(new Word("teṭe", "older sister"));
        familyMembers.add(new Word("kolliti", "younger sister"));
        familyMembers.add(new Word("ama","grandmother"));
        familyMembers.add(new Word("paapa","grandfather"));


        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
