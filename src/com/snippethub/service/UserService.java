
package com.snippethub.service;

import com.snippethub.model.User;
import java.util.List;

/**
*
* @author Haftom Alemayehu
*/
public interface UserService {
   public List<User> getAllUsers();
   public User getUserByID( long userID );
   public void addUser(User user);
   public boolean deleteUser(String userID);
   public boolean editUser(User user);
   public boolean authenticate(User user);
   public User getUserByFirstName(String firstName);
   public User getUserByEmail(String email); 
    public List<User> getAllUsersWithCount();

    public Object getSnippetListByFirstName(String firstName);
}
