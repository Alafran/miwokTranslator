package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 1/3/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    List<Word> words;

    public WordAdapter(Context context, ArrayList<Word> objects) {
        super(context, 0, objects);
        words = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        TextView defaultWordTextView = (TextView) convertView.findViewById(R.id.default_text_view);
        TextView translationTextView = (TextView) convertView.findViewById(R.id.translation_text_view);

        defaultWordTextView.setText(words.get(position).getDefaultTranslation());
        translationTextView.setText(words.get(position).getMiwokTranslation());


        return convertView;
    }

}
