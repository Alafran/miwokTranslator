package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        };

        final ArrayList<Word> familyMembers = new ArrayList<>();
        familyMembers.add(new Word("әpә","father",R.drawable.family_father,R.raw.family_father));
        familyMembers.add(new Word("әṭa", "mother",R.drawable.family_mother,R.raw.family_mother));
        familyMembers.add(new Word("angsi", "son",R.drawable.family_son,R.raw.family_son));
        familyMembers.add(new Word("tune", "daughter",R.drawable.family_daughter,R.raw.family_daughter));
        familyMembers.add(new Word("taachi", "older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        familyMembers.add(new Word("chalitti", "younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        familyMembers.add(new Word("teṭe", "older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        familyMembers.add(new Word("kolliti", "younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        familyMembers.add(new Word("ama","grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        familyMembers.add(new Word("paapa","grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, familyMembers, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, familyMembers.get(i).getMp3ResourceID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

        listView.setAdapter(itemsAdapter);


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
