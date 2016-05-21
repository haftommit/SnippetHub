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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class InMemorySnippetRepository implements SnippetRepository {

    public InMemorySnippetRepository() throws IOException {
        List<Tag> listOfTags1 = new ArrayList<>();
        List<Tag> listOfTags2 = new ArrayList<>();
        List<Tag> listOfTags3 = new ArrayList<>();
        List<Tag> listOfTags4 = new ArrayList<>();
        Tag tag2 = new Tag("validation");
        Tag tag21 = new Tag("javascript");
        listOfTags2.add(tag2);
        listOfTags2.add(tag21);

        Tag tag1 = new Tag("php");
        Tag tag12 = new Tag("register");
        listOfTags1.add(tag1);
        listOfTags1.add(tag12);

        Tag tag3 = new Tag("python");
        listOfTags3.add(tag3);

        Tag tag4 = new Tag("java");
        Tag tag42 = new Tag("convertor");
        Tag tag43 = new Tag("binary");
        listOfTags4.add(tag4);
        listOfTags4.add(tag42);
        listOfTags4.add(tag43);

        String key = readFromFile("php");
        String key2 = readFromFile("js");
        String key3 = readFromFile("python");
        String key4 = readFromFile("java");
        Snippet sn1 = new Snippet("php", "Register User", key, "user register php code", "public", listOfTags1, "rahel");
        Snippet sn2 = new Snippet("javascript", "Password Validations", key2, "validate password field ", "public", listOfTags2, "tare");
        Snippet sn3 = new Snippet("python", "Get the Geo Location", key3, "Get the Geo Location of an IP Address", "private", listOfTags3, "rahel");
        Snippet sn4 = new Snippet("python", "Binary Convertor", key4, "convert to binary number", "private", listOfTags4, "tare");
        listOfSnippet.add(sn1);
        listOfSnippet.add(sn2);
        listOfSnippet.add(sn3);
        listOfSnippet.add(sn4);
    }

    public String readFromFile(String fileName) throws FileNotFoundException, IOException {
        /*String path = new ClassPathResource("languages" + File.separator + fileName + ".txt").getFilename();
//"/resources/languages/"+fileName+".txt";*/
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("languages/"+fileName+".txt").getFile());
        
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    }

    private final List<Snippet> listOfSnippet = new ArrayList<>();

    @Override
    public List<Snippet> getAllSnippets() {
        return listOfSnippet;
    }

    @Override
    public Snippet getSnippetById(long snippetId) {
        for (Snippet snippet : listOfSnippet) {
            if (snippet.getSnippetId() == (snippetId)) {
                return snippet;
            }
        }
        throw new IllegalArgumentException(
                String.format("Snippet with id %s not found", snippetId));
    }

    @Override
    public void addSnippet(Snippet snippet) {

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
    public List<Snippet> getSnippetListByFirstName(String firstName) {
        List<Snippet> userSnippetList = new ArrayList<>();
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
    public List<Snippet> getSharedSnippetsByFirstName(String firstName, String visibility) {
        List<Snippet> userSnippetList = new ArrayList<>();

        for (Snippet snippet : listOfSnippet) {
            if (snippet.getOwner().equals(firstName)) {
                if (visibility.equals("all")) {
                    userSnippetList.add(snippet);
                } else if (snippet.getVisiblity().equals("public")) {
                    userSnippetList.add(snippet);
                }
            }
        }

        return userSnippetList;
    }

    @Override
    public void deleteSnippet(String slug) {
        for (Snippet snippet : listOfSnippet) {
            if (snippet.getSlug().equals(slug)) {
                listOfSnippet.remove(snippet);
                break;
            }
        }
    }

    @Override
    public void editSnippet(Snippet snippet) {

        for (Snippet existing : listOfSnippet) {
            if (existing.getSlug().equals(snippet.getSlug())) {

                existing.setContent(snippet.getContent());
                existing.setSnippetTitle(snippet.getSnippetTitle());
                existing.setVisiblity(snippet.getVisiblity());
                existing.setLanguage(snippet.getLanguage());
                existing.setTags(snippet.getTags());
                existing.setSnippetDescription(snippet.getSnippetDescription());
            }
        }

    }
}
