/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.controller;

import com.snippethub.model.TagEntity;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tekeste
 */
@Controller
@RequestMapping("/tags")
public class TagController {

    /**
     * Display all tags
     *
     * @return
     */
    @Transactional
    @RequestMapping
    public String tags() {
        return "tag/index";
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public void createTag(@RequestBody TagEntity tagEntity) {
        
    }
    
}
