
package com.snippethub.service;

import com.snippethub.model.Tag;
import java.util.List;

/**
*
* @author Haftom Alemayehu
*/
public interface TagService {
   public List<Tag> getAllTags();
   public Tag getTagByID( long tagID );
   public void addTag(Tag user);
   public boolean deleteTag(String tagID);
   public boolean editTag(Tag user);
  public List<Tag> getAllTagsWithCount();
}
