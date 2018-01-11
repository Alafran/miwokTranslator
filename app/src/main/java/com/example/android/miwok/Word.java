package com.example.android.miwok;

/**
 * Created by Joey on 1/2/2018.
 * <p>
 * Word represents a vocabulary word the user wants to learn.
 * It contains both a default translation and a miwok translation.
 */

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private int imageResourceID;
    private int mp3ResourceID;

    public Word(String miwokTranslation, String defaultTranslation) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceID = 0;
        this.mp3ResourceID = 0;
    }

    public Word(String miwokTranslation, String defaultTranslation, int imageResourceID) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceID = imageResourceID;
        this.mp3ResourceID = 0;
    }

    public Word(String miwokTranslation, String defaultTranslation, int imageResourceID, int mp3ResourceID) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceID = imageResourceID;
        this.mp3ResourceID = mp3ResourceID;
    }

    public Word(String miwokTranslation, int mp3ResourceID, String defaultTranslation) {
        this.miwokTranslation = miwokTranslation;
        this.mp3ResourceID = mp3ResourceID;
        this.defaultTranslation = defaultTranslation;
        this.imageResourceID = 0;
    }

    public String getMiwokTranslation() {
        return this.miwokTranslation;
    }

    public String getDefaultTranslation() {
        return this.defaultTranslation;
    }

    public int getimageResourceID() {
        return this.imageResourceID;
    }

    public int getMp3ResourceID() {
        return this.mp3ResourceID;
    }

}
