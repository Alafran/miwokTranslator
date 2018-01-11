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

public class PhrasesActivity extends AppCompatActivity {

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

        final ArrayList<Word> phrases = new ArrayList<>();
        phrases.add(new Word("minto wuksus", R.raw.phrase_where_are_you_going,"Where are you going?"));
        phrases.add(new Word("tinnә oyaase'nә",R.raw.phrase_what_is_your_name, "What is your name?"));
        phrases.add(new Word("oyaaset...",R.raw.phrase_my_name_is, "My name is..."));
        phrases.add(new Word("michәksәs?", R.raw.phrase_how_are_you_feeling,"How are you feeling?"));
        phrases.add(new Word("kuchi achit",R.raw.phrase_im_feeling_good, "I'm feeling good"));
        phrases.add(new Word("әәnәs'aa?",R.raw.phrase_are_you_coming, "Are you coming?"));
        phrases.add(new Word("hәә’ әәnәm",R.raw.phrase_yes_im_coming, "Yes, I'm coming."));
        phrases.add(new Word("әәnәm",R.raw.phrase_im_coming, "I'm coming."));
        phrases.add(new Word("yoowutis",R.raw.phrase_lets_go, "Let's go."));
        phrases.add(new Word("әnni'nem",R.raw.phrase_come_here, "Come here."));

        final WordAdapter itemsAdapter = new WordAdapter(this, phrases, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this,phrases.get(i).getMp3ResourceID());
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
