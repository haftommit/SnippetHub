package com.snippethub.service.impl;
import com.snippethub.model.Snippet;
import com.snippethub.repository.UserRepository;
import com.snippethub.model.User;
import com.snippethub.service.SnippetService;
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
public class UserServiceImpl implements UserService {
    
    //JpaUserRepository userRepository;
    @Autowired UserRepository userRepository;    
    @Autowired SnippetService snippetService;
    /*
    public UserServiceImpl() {
        userRepository = new JpaUserRepository();
    }

    public UserServiceImpl(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    } */
       
    
    @Override
    public boolean authenticate(User user) {
        User userWithMatchingId = userRepository.getUserByEmail(user.getEmail());
        if(userWithMatchingId != null)
            return userWithMatchingId.getPassword().equals(user.getPassword());
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        if (userRepository == null ) {
            throw new IllegalArgumentException("userRepository is null");
        }
        userRepository.addUser(user);
    }

    @Override
    public boolean deleteUser(String userID) {
        return false;
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public User getUserByID(long userID) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
       return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByFirstName(String firstName) {
        return userRepository.getUserByFirstName(firstName);
    }

    @Override
    public List<Snippet> getSnippetListByFirstName(String firstName) {
        return snippetService.getSnippetListByFirstName(firstName);
    }
    
    
       @Override
    public List<User> getAllUsersWithCount() {
        List<User> usersWithCounts = new ArrayList<>();
        User temp;
        int count = 0;
        for (User user : this.getAllUsers()) {
            count = snippetService.getSnippetListByFirstName(user.getSlug()).size();
            temp = user;
            temp.setCount(count);
            usersWithCounts.add(temp);
        }
        return usersWithCounts;
    }
}
