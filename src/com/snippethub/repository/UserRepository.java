
package com.snippethub.repository;
/**
*
* @author Haftom Alemayehu
*/
import com.snippethub.model.User;
import java.util.List;


public interface UserRepository {
    
   public User getUserByID( long userID);
   public List<User> getAllUsers();
   public void addUser(User user);
   public User getUser( String userID);
   public void deleteUser(User userID);
   public boolean editUser(User user);
   public boolean authenticate(User user);
   public User getUserByEmail(String email);
   public User getUserByFirstName(String firstName);

}