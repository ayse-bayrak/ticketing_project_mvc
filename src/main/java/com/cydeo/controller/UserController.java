package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create") //localhost:8080/user/create
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        //basically all the roles, all the users, all the projects, all the managers everything is located in the DB
        //so i need a mechanism to bring all those data from database
        //find all roles from DB, this is business logic
        //how I'm gonna bring something to controller from the database
        //from the Service layer
        //service layer
        //why UserDTO, let's look at the picture, which object is going to view
        //DTO is going to controller and then this DTO is going to pass from Controller

        model.addAttribute("users", userService.findAll());

        return "user/create";
        //whatever inside that view any object, ant attribute you need to provide it inside this method
        //because this method is returning this view
    }

//    @GetMapping("/create1") //localhost:8080/user/create1
//    public String createUser2(){
//        //if i have different method which is returning same view, whatever we needs(objects, list of something)- you need provide it
//        return "user/create";
//    }

@PostMapping("/create")
public String insertUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult, Model model){
//
    if(bindingResult.hasErrors()){
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/create";
    }
    userService.save(user);// when we work in the database save and update is not gonna be the same
    //in the business logic in the database we are gonna write one logic for save, we need to write another logic in the database

    //I use redirect and i don't need to again portion
    return "redirect:/user/create";
}

//    @PostMapping("/create")
//    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){
// whatever view that method is returning you need to go to that view (create html)
//        // you need to provide from this method whatever needs all attributes (user objects, roles, users)
//        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", roleService.findAll());
//        userService.save(user);
//        model.addAttribute("users", userService.findAll());
//        //but I use redirect and i don't need to again portion
//
//        return "user/create";
//    }

    //Anything related with the user, which is create user update use delet user everything
    //I will build it inside this controller

    @GetMapping("/update/{username}")
    public String editUser(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user) {
        // i need to update that user, we need to service, do we have any service
        // we create business  which is updating
        userService.update(user);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteById(username);
        return "redirect:/user/create";
    }

//    @GetMapping("/delete")
//    public String deleteUser(@ModelAttribute ("user") UserDTO user) {
//        userService.deleteById(user.getUserName());
//        return "redirect:/user/create";
//    }
    /**
    Question And here can I use @ModelAttribute like this instead of @PathVariable ?
    if the answer is yes, what should I change html file to capture 'user' attribute?
     */
/*
 we use the @ModelAttribute for capturing objects. But we use the @PathVariable for capturing data from the endpoint.
 For example for update/{username} the username is only a single data and not object, that's why we need to use @PathVariable here.

But when we submit a form, for example for user create page, we are actually creating a user object,
and in order to capture this user object, we need to use the @ModelAttribute.

But while you delete the user, you are not really submitting a new object, we are only selecting one existing user from the list,
and we have the details of the user such as their username, that is why we capture it using the endpoint and @PathVariable
and then delete the user based on it
 */

}
