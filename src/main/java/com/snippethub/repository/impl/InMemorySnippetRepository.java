/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.repository.impl;


import com.snippethub.repository.SnippetRepository;
import com.snippethub.model.Snippet;
import com.snippethub.model.Tag;
import com.snippethub.model.util.Util;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rakesh Shrestha
 */
@Repository
public class InMemorySnippetRepository implements SnippetRepository {

    public InMemorySnippetRepository() {
        List<Tag> listOfTags = new ArrayList<>();
        Tag tag1 = new Tag("javascript");
        listOfTags.add(tag1);
        Snippet sn1 = new Snippet("javascript", "Arrow functions", "x => x+1", "Increment x by 1", "public", listOfTags, "rahel");
        listOfSnippet.add(sn1);
    }   

    private final List<Snippet> listOfSnippet = new ArrayList<>();
    @Override
    public List<Snippet> getAllSnippets() {
        return listOfSnippet;
    }

    @Override
    public Snippet getSnippetById(long snippetId) {
        for(Snippet snippet: listOfSnippet){
            if(snippet.getSnippetId()==(snippetId)) {
                return snippet;
            } 
        }
        throw new IllegalArgumentException(
                String.format("Snippet with id %s not found", snippetId));
    }
    
     @Override
    public void addSnippet(Snippet snippet){

        listOfSnippet.add(snippet);
    }

    @Override
    public Snippet getSnippetByTitle(String title) {
        for (Snippet snippet : listOfSnippet) {
            if (snippet.getSlug().equals(Util.getSlug(title))) {
                return snippet;
            }
        }
        return null;
    }
     @Override
    public List<Snippet> getSnippetListByFirstName(String firstName){
        List<Snippet> userSnippetList=new ArrayList<>();
        for (Snippet snippet : listOfSnippet) {
            if (snippet.getOwner().equals(firstName)) {
                userSnippetList.add(snippet);
            }
        }
        return userSnippetList;
    }
    @Override
    public List<Snippet> getSnippetByTagTitle(String tagTitle) {
        List<Snippet> tagSnippetList = new ArrayList<>();
        for (Snippet snippet : listOfSnippet) {

            List<Tag> tg = snippet.getTags();
            int counter = 0;
            for (Tag tt : tg) {
                if (tt.getTagTitle().equals(tagTitle)) {
                    counter = 1;
                }
            }

            if (counter == 1) {
                tagSnippetList.add(snippet);
            }
        }
        return tagSnippetList;
    }
        @Override
    public List<Snippet> getSharedSnippetsByFirstName( String firstName, String visibility ){       
        List<Snippet> userSnippetList= new ArrayList<>();
        
            for (Snippet snippet : listOfSnippet) {
                if (snippet.getOwner().equals(firstName) ) 
                     if( visibility.equals("all") ) {
                           userSnippetList.add(snippet);
                     } else if( snippet.getVisiblity().equals("public")){
                           userSnippetList.add(snippet);
                     }
            } 
                
         return userSnippetList;
    }
}
