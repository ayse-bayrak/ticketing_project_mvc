package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        model.addAttribute("userList", userService.findAll());

        return "user/create";
    }

}
