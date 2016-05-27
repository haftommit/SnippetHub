package com.snippethub.model;

import com.snippethub.model.util.Util;
import java.io.Serializable;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
/**
*
* @author Haftom Alemayehu <Haftom Alemayehu>
*/

public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long userID;
    
    @NotEmpty(message = "{register.user.email}")
    @Email(message = "{register.user.email}")
    private String email;

    @NotEmpty(message = "{register.user.password}")
    private String password;

    @NotEmpty(message = "{register.user.firstName}")
    private String firstName;
    @NotEmpty(message = "{register.user.lastName}")
    private String lastName;

    private String biography;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String phone;

    private String profilePicture;
    private int count;
    public User() {
    }

    public User(String email, String password, String firstName, String lastName, String biography, String phone, String profilePicture) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.phone = phone;
        this.profilePicture = profilePicture;
    }

    public User(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
    }
    
    
    //getters
    public Long getUserID() {
        return userID;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getFullName() {
        return firstName + " " + lastName;  
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }
    //setters
    public void setUserID(Long userID) {
       
     this.userID = userID;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSlug() {
        return Util.getSlug(this.firstName);
    }

}