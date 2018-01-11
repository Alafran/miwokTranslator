package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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

        final ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","one",R.drawable.number_one,R.raw.number_one));
        numbers.add(new Word("otiiko", "two",R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("tolookosu", "three",R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("oyyisa", "four",R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("massokka", "five",R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("temmokka", "six",R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("kenekaku", "seven",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("kawinta", "eight",R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("wo'e", "nine",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("na'aacha", "ten",R.drawable.number_ten,R.raw.number_ten));

        final WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,numbers.get(position).getMp3ResourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
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
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
