package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> familyMembers = new ArrayList<>();
        familyMembers.add(new Word("әpә","father",R.drawable.family_father));
        familyMembers.add(new Word("әṭa", "mother",R.drawable.family_mother));
        familyMembers.add(new Word("angsi", "son",R.drawable.family_son));
        familyMembers.add(new Word("tune", "daughter",R.drawable.family_daughter));
        familyMembers.add(new Word("taachi", "older brother",R.drawable.family_older_brother));
        familyMembers.add(new Word("chalitti", "younger brother",R.drawable.family_younger_brother));
        familyMembers.add(new Word("teṭe", "older sister",R.drawable.family_older_sister));
        familyMembers.add(new Word("kolliti", "younger sister",R.drawable.family_younger_sister));
        familyMembers.add(new Word("ama","grandmother",R.drawable.family_grandmother));
        familyMembers.add(new Word("paapa","grandfather",R.drawable.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }

}
