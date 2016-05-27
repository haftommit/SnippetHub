package com.snippethub.service.impl;
import com.snippethub.model.Snippet;
import com.snippethub.model.Tag;
import com.snippethub.repository.UserRepository;
import com.snippethub.model.User;
import com.snippethub.repository.TagRepository;
import com.snippethub.service.SnippetService;
import com.snippethub.service.TagService;
import com.snippethub.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
*
* @author Haftom Alemayehu
*/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository repository;
    @Autowired
    SnippetService snippetService;
    
    @Override
    public List<Tag> getAllTags() {
        return repository.getAllTags();
    }
    

    @Override
    public Tag getTagByID(long tagID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTag(Tag tag) {
        repository.addTag(tag);
    }

    @Override
    public boolean deleteTag(String tagID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editTag(Tag user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //JpaUserRepository userRepository;

    @Override
    public List<Tag> getAllTagsWithCount() {
        List<Tag> tagsWithCounts = new ArrayList<>();
        Tag temp;
        int count = 0;
        for(Tag tag : this.getAllTags()) {
            temp = tag;
            count = snippetService.getSnippetByTagTitle(tag.getTagTitle()).size();
            temp.setCount(count);
            tagsWithCounts.add(temp);
        }
        return tagsWithCounts;
    }
}
