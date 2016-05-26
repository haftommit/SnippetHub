/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snippethub.controller;

import com.snippethub.model.Tag;
import com.snippethub.model.TagEntity;
import com.snippethub.service.TagService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Haftom Alemayehu <Haftom Alemayehu>
*/
@Controller
public class TagController {

    /**
     * Display all tags
     *
     * @return
     */
    @Autowired
    TagService tagService;

    @RequestMapping(value="/tags", method = RequestMethod.GET)
    public String getAllTags(Model model) {
        model.addAttribute("tags", tagService.getAllTagsWithCount());
        return "tag/index";
    }
    
    @RequestMapping(value="/savetags", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody public void createTag(@RequestBody TagEntity tagEntity) {
        Tag newTag = new Tag(tagEntity.getTagTitle(), tagEntity.getTagDescription());
        tagService.addTag(newTag);
    }
    
}
