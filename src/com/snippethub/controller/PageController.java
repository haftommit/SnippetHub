/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.controller;

import com.snippethub.service.SnippetService;
import com.snippethub.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Haftom Alemayehu
 */
@Controller
public class PageController {
    @Autowired
    SnippetService snippetService;
    @Autowired
    TagService tagService;
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("snippets", snippetService.getAllSnippets());
        model.addAttribute("homeTags", tagService.getAllTags() );
        return "index";
    }
}
