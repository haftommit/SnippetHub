/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.service;

import com.snippethub.model.Language;
import com.snippethub.model.Snippet;
import com.snippethub.model.Tag;

import java.util.List;

/**
*
* @author Haftom Alemayehu
*/
public interface SnippetService {
    public List<Snippet> getAllSnippets();
    public Snippet getSnippetById(long SnippetID);
    public void addSnippet(Snippet snippet); 
    public List<Language> getAllLaungauges();
    public Snippet getSnippetByTitle(String title);
    public List<Snippet> search(String searchTerm);
    public List<Snippet> getSnippetListByFirstName(String firstName);
    public List<Snippet> getSnippetByTagTitle(String tagTitle);
    public List<Snippet> getSharedSnippetsByFirstName( String firstName, String visibility );     
    public void editSnippet( Snippet snippet);
    public void deleteSnippet(String slug);
}
