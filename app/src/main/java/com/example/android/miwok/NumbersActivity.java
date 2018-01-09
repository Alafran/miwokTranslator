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

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","one",R.drawable.number_one));
        numbers.add(new Word("otiiko", "two",R.drawable.number_two));
        numbers.add(new Word("tolookosu", "three",R.drawable.number_three));
        numbers.add(new Word("oyyisa", "four",R.drawable.number_four));
        numbers.add(new Word("massokka", "five",R.drawable.number_five));
        numbers.add(new Word("temmokka", "six",R.drawable.number_six));
        numbers.add(new Word("kenekaku", "seven",R.drawable.number_seven));
        numbers.add(new Word("kawinta", "eight",R.drawable.number_eight));
        numbers.add(new Word("wo'e", "nine",R.drawable.number_nine));
        numbers.add(new Word("na'aacha", "ten",R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        final MediaPlayer mediaPlayer = MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
        final Toast toast = Toast.makeText(NumbersActivity.this,"Playing Translation", Toast.LENGTH_SHORT);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast.show();
                mediaPlayer.start();
            }
        });

        listView.setAdapter(itemsAdapter);

    }

}
