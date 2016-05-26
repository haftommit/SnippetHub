
package com.snippethub.controller;

//import com.snippethub.service.UserService;
import com.snippethub.model.User;
import com.snippethub.service.SnippetService;
import com.snippethub.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
*
* @author Haftom Alemayehu <Haftom Alemayehu>
*/

@Controller
public class UserController {
 
    @Autowired
    UserService userService;
    @Autowired
    SnippetService snippetService;
    /**
     * Display all users
     * @return 
     */
    @RequestMapping("/users")
    public String users(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
          model.addAttribute("users", userService.getAllUsersWithCount());
        return "user/index";
    }
    
    /**
     * Display user profile
     */
    @RequestMapping(value = "/users/{firstName}", method = RequestMethod.GET)
    public String getProfile(@PathVariable("firstName") String firstName, Model model, HttpServletRequest request) {
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");

        String visiblity = "";
        if (loggedInUser != null && loggedInUser.getSlug().equals(firstName)) {
            visiblity = "all";
        } else {
            visiblity = "public";
        }
//        model.addAttribute("vis",snippetService.getSharedSnippetsByFirstName(firstName, visiblity).size());
        model.addAttribute("userSnippets", snippetService.getSharedSnippetsByFirstName(firstName, visiblity));
        model.addAttribute("singleUser", userService.getUserByFirstName(firstName));
//        model.addAttribute("userSnippets",userService.getSnippetListByFirstName(firstName));
//        model.addAttribute("sharedSnippets",snippetService.getSharedSnippets() );
        // model.addAttribute("snippetCount",snippetService.getSharedSnippets().c )
        return "user/show";
    }
    /**
     * Display the login form
     * @return 
     */
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginForm(Model model) {
        User user = new User();
        model.addAttribute("currentUser", user);
        return "user/login";
    }
    
    /**
     * Display the login form
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("currentUser") User user, RedirectAttributes redirectAttributes, Model model
    , HttpServletRequest request) {
        if(userService.authenticate(user)) {
            User loggedInUser = userService.getUserByEmail(user.getEmail());
            request.getSession().setAttribute("loggedInUser", loggedInUser);
            redirectAttributes.addFlashAttribute("loginError", "yes");
            return "redirect:/users/"+loggedInUser.getSlug();
        }
        else {
          redirectAttributes.addFlashAttribute("loginError", "no");
          return "redirect:/login";
        }
    }
    
    /**
     * Display the register form
     * @return 
     */
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String getRegisterForm(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "user/register";
    }

    /**
     * Save new user
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registeUser(@ModelAttribute("newUser") @Valid User newUser, BindingResult result) {
        if(result.hasErrors()) {
          return "user/register";
        }
        userService.addUser(newUser);
        return "redirect:/login";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
    
}
