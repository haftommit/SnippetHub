/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.model;

import java.io.Serializable;
/**
*
* @author Haftom Alemayehu
*/
public class TagEntity implements Serializable {
    private String tagTitle;
    private String tagDescription;
    
    public TagEntity(String tagTitle, String tagDescription) {
        this.tagTitle = tagTitle;
        this.tagDescription = tagDescription;
    }
    public TagEntity(){}

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }
}
