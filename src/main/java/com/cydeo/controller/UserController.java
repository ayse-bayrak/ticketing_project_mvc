package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/create") //localhost:8080/user/create
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());

        //why UserDTO, let's look at the picture, which object is going to view
        //DTO is going to controller and then this DTO is going to pass from Controller
        return "user/create";
    }

}
