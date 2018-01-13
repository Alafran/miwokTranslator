package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);


        audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    case AudioManager.AUDIOFOCUS_GAIN:
                        mMediaPlayer.start();
                        break;
                    case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                        mMediaPlayer.start();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        mMediaPlayer.pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS:

                        releaseMediaPlayer();
                        break;
                }
            }
        };


        final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        };

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi","red",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("chokokki", "green",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("ṭakaakki", "brown",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("ṭopoppi", "gray", R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("kululli", "black",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("kelelli", "white",R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("ṭopiisә", "dusty yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("chiwiiṭә", "mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this, colors,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                int audioFocusRequest = mAudioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(audioFocusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, colors.get(i).getMp3ResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }


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

            mAudioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

}
