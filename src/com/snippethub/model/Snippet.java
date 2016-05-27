/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.model;

import com.snippethub.model.util.Util;
import java.io.Serializable;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
*
* @author Haftom Alemayehu
*/
public class Snippet implements Serializable {

    private long snippetId;
    @NotEmpty(message = "{snippet.title}")
    private String snippetTitle;
    private String snippetDescription;
    @NotEmpty(message = "{snippet.content}")
    private String content;
    private Date createDate;
    private Date modifiedDate;
    private String snippetLanguage;
    private String visiblity = "private";
    private List<Tag> tags;
    private String owner;

    public String getSnippetLanguage() {
        return snippetLanguage;
    }

    public void setSnippetLanguage(String snippetLanguage) {
        this.snippetLanguage = snippetLanguage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public Snippet() {
        this.tags = new ArrayList<>();
    }

    public Snippet(String snippetTitle, String snippetDescription, String snippetContent, Date createDate, Date modifiedDate, String snippetLanguage, String visiblity, List<Tag> tags, String owner) {
        this.snippetTitle = snippetTitle;
        this.snippetDescription = snippetDescription;
        this.content = snippetContent;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.snippetLanguage = snippetLanguage;
        this.visiblity = visiblity;
        this.tags = tags;
        this.owner = owner;
    }

    public Snippet(String snippetLanguage, String snippetTitle, String snippetContent, String snippetDescription, String visiblity, List<Tag> mytags, String owner) {
        this.snippetTitle = snippetTitle;
        this.snippetDescription = snippetDescription;
        this.content = snippetContent;
        this.snippetLanguage = snippetLanguage;
        this.visiblity = visiblity;
        this.tags = mytags;
        this.owner = owner;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public long getSnippetId() {
        return snippetId;
    }

    public void setSnippetId(long snippetID) {
        this.snippetId = snippetID;
    }

    public String getSnippetTitle() {
        return snippetTitle;
    }

    public void setSnippetTitle(String snippetTitle) {
        this.snippetTitle = snippetTitle;
    }

    public String getSnippetDescription() {
        return snippetDescription;
    }

    public void setSnippetDescription(String snippetDescription) {
        this.snippetDescription = snippetDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String snippetContent) {
        this.content = snippetContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getLanguage() {
        return snippetLanguage;
    }

    public void setLanguage(String language) {
        this.snippetLanguage = language;
    }

    public String getVisiblity() {
        return visiblity;
    }

    public void setVisiblity(String visiblity) {
        this.visiblity = visiblity;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public String getSlug() {
        return Util.getSlug(this.snippetTitle);
    }
}
