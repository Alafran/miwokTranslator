package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joey on 1/3/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private List<Word> words;
    private int backgroundColor;

    public WordAdapter(Context context, ArrayList<Word> objects, int color) {
        super(context, 0, objects);
        words = objects;
        this.backgroundColor = color;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        TextView defaultWordTextView = (TextView) convertView.findViewById(R.id.default_text_view);
        TextView translationTextView = (TextView) convertView.findViewById(R.id.translation_text_view);
        ImageView image = (ImageView) convertView.findViewById(R.id.image_view);
        LinearLayout textContainer = (LinearLayout) convertView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), backgroundColor);

        textContainer.setBackgroundColor(color);


        defaultWordTextView.setText(words.get(position).getDefaultTranslation());
        translationTextView.setText(words.get(position).getMiwokTranslation());
        if (this.words.get(position).getimageResourceID() != 0) {
            image.setImageResource(words.get(position).getimageResourceID());
            image.setVisibility(View.VISIBLE);
        }


        return convertView;
    }

}
