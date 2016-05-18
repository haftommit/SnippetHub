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
 * @author tareman
 */
public interface SnippetRepository {
    List<Snippet> getAllSnippets();
    Snippet getSnippetById(long snippetID);
    void addSnippet(Snippet snippet);
   // void initRepository();

    public Snippet getSnippetByTitle(String title);
}
