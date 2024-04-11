package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/task")
public class TaskController {
    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("task", new TaskDTO());
       // model.addAttribute("task", new Tas);
        return "/task/create";
    }
}
