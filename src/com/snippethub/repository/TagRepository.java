
package com.snippethub.repository;

import com.snippethub.model.Tag;
import java.util.List;

/**
*
* @author Haftom Alemayehu
*/
public interface TagRepository {
    
   public Tag getTagByID( String tagID);
   public List<Tag> getAllTags();
   public void addTag(Tag tag);
   public Tag getTag( String tagID);
   public void deleteTag(Tag tagID);
   public boolean editTag(Tag tag);
}
