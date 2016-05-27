/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.repository;

import com.snippethub.model.Snippet;
import java.util.List;

/**
*
* @author Haftom Alemayehu
*/
public interface SnippetRepository {

    List<Snippet> getAllSnippets();

    Snippet getSnippetById(long snippetID);

    void addSnippet(Snippet snippet);
    // void initRepository();

    public Snippet getSnippetByTitle(String title);

    public List<Snippet> getSnippetListByFirstName(String firstName);

    public List<Snippet> getSnippetByTagTitle(String tagTitle);

    public List<Snippet> getSharedSnippetsByFirstName(String firstName, String visibility);

    public void deleteSnippet(String slug);
    public void editSnippet( Snippet snippet);

}
