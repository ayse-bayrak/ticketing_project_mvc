package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {

   private final UserService userService;
   private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        //List<UserDTO> managers = new ArrayList<>();
        //managers = userService.findAll().stream().filter(p->p.getRole().getDescription().equals("manager")).collect(Collectors.toList());
        model.addAttribute("managers", userService.findAll() );
        model.addAttribute("projects", projectService.findAll() );
        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){

        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String insertProject(@PathVariable ("projectCode") String projectCode){

        projectService.deleteById(projectCode);

        return "redirect:/project/create";
    }
}
