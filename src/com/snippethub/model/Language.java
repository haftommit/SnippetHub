package com.snippethub.model;


import java.util.*;

/**
 * 
 */
public class Language {

    /**
     * Default constructor
     */
    public Language() {
    }

    /**
     * 
     */
    private long languageId;

    /**
     * 
     */
    private String languageName;

    public Language(int languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }



}