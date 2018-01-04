package com.example.android.miwok;

/**
 * Created by Joey on 1/2/2018.
 *
 * Word represents a vocabulary word the user wants to learn.
 * It contains both a default translation and a miwok translation.
 */

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;

    public Word(String miwokTranslation, String defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public String getMiwokTranslation() {
        return this.miwokTranslation;
    }

    public String getDefaultTranslation() {
        return  this.defaultTranslation;
    }

}
