/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.service.impl;

import com.snippethub.model.Language;
import com.snippethub.repository.SnippetRepository;
import com.snippethub.model.Snippet;
import com.snippethub.repository.TagRepository;
import com.snippethub.service.SnippetService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


/**
*
* @author Haftom Alemayehu
*/
@Service
public class SnippetServiceImpl implements SnippetService{
    
    @Autowired
    SnippetRepository snippetRepository;
    @Autowired
    TagRepository tagRepository;
    @Override
    public List<Snippet> getAllSnippets() {
        return snippetRepository.getAllSnippets();
    }

    @Override
    public Snippet getSnippetById(long snippetID) {
        return snippetRepository.getSnippetById(snippetID);
    }
    
    @Override
    public void addSnippet(Snippet snippet){
       snippetRepository.addSnippet(snippet);
    }
    
    @Override
    public List<Language> getAllLaungauges() {
        List<Language> languages = new ArrayList<>();
        Language lang1 = new Language(1, "javascript");
        Language lang2 = new Language(2, "php");
        Language lang3 = new Language(3, "ruby");
        languages.add(lang1);
        languages.add(lang2);
        languages.add(lang3);
        return languages;
    }

    @Override
    public Snippet getSnippetByTitle(String title) {
        return snippetRepository.getSnippetByTitle(title);
    }

    @Override
    public List<Snippet> search(String searchTerm) {
        List<Snippet> all = this.getAllSnippets();
        List<Snippet> matching = new ArrayList<>();
        //if the search term is empty return all the snippets :) or in my case XXX
        if(searchTerm.equals("XXX"))
            return all;
        for (Snippet snippet : all) {
            if(snippet.getVisiblity().equals("public")) {
                if (snippet.getSnippetTitle().toLowerCase().contains(searchTerm)) {
                    matching.add(snippet);
                } else if (snippet.getTags().toString().contains(searchTerm)) {
                    matching.add(snippet);
                } else if (snippet.getOwner().contains(searchTerm)) {
                    matching.add(snippet);
                } else if (snippet.getSnippetDescription().toLowerCase().contains(searchTerm)) {
                    matching.add(snippet);
                }
            }
        }
        return matching;
    }
    @Override
    public List<Snippet> getSnippetListByFirstName(String firstName) {
        return snippetRepository.getSnippetListByFirstName(firstName);
    }

    @Override
    public List<Snippet> getSnippetByTagTitle(String tagTitle) {
        return snippetRepository.getSnippetByTagTitle(tagTitle);
    }
    
        @Override
    public List<Snippet> getSharedSnippetsByFirstName(String firstName, String visibility) {
        return snippetRepository.getSharedSnippetsByFirstName(firstName, visibility);
    }

    @Override
    public void deleteSnippet(String slug) {
        snippetRepository.deleteSnippet(slug);
    }
    
    @Override
    public void editSnippet(Snippet snippet) {

        snippetRepository.editSnippet(snippet);
    }
}
