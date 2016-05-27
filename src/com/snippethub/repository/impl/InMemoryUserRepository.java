
package com.snippethub.repository.impl;

import com.snippethub.model.User;
import com.snippethub.model.util.Util;
import com.snippethub.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
*
* @author Haftom Alemayehu
*/
@Repository
public class InMemoryUserRepository implements UserRepository {
    
     Map<Long, User> users;

    public InMemoryUserRepository() {
        users = new HashMap<>();
        User user1 = new User("t@t.com","pass", "Rahel", "Kidanu");
        User user2 = new User("tare@mum.com","pass", "Tare", "Sisay");
        User user3 = new User("tek@mum.com","pass", "Tekeste", "Kidanu");
        User user4 = new User("haf@mum.com","pass", "Haftom", "Tesfaye");
         User user5 = new User("yerga@mum.com","pass", "Yergalem", "Gebretsadik");
        users.put(Long.MIN_VALUE, user1);
        users.put(Long.MIN_VALUE +1, user2);
        users.put(Long.MIN_VALUE +2, user3);
        users.put(Long.MIN_VALUE +3, user4);
        users.put(Long.MIN_VALUE+6, user5);
    }

    @Override
    public User getUserByID(long userID) {
     
       return users.get( userID );
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        
        if ( usersList == null ) {
            throw new NullPointerException("No Users Data can be fetched");
        }
        
        for ( User user : users.values() ) {
              usersList.add(user);
        }
        
        return usersList;
    }

    @Override
    public void addUser(User user) {
        users.put( user.getUserID(), user);
    }

    @Override
    public User getUser(String userID) {
        
        for (User user :  users.values() ) {
            if(user.getUserID().equals(userID)) 
                return user;
        }
        
        throw new NullPointerException(InMemoryUserRepository.class.getSimpleName()+"No mathing User Found");
    }

    @Override
    public void deleteUser(User userID) {
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public boolean authenticate(User user) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users.values()) {

            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByFirstName(String firstName) {
        for (User user :  users.values() ) {
            if(user.getSlug().equals(Util.getSlug(firstName))) 
                return user;
            }
        return null;
    }
    
    
}
