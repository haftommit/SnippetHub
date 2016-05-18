/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.service.impl;

import com.snippethub.model.Language;
import com.snippethub.repository.SnippetRepository;
import com.snippethub.model.Snippet;
import com.snippethub.service.SnippetService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


/**
 *
 * @author tareman
 */
@Service
public class SnippetServiceImpl implements SnippetService{
    
    @Autowired
    SnippetRepository snippetRepository;
    
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
    
}
