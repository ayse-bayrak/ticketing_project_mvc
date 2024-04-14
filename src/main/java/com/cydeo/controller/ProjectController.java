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
        model.addAttribute("managers", userService.findManagers() );
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
    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(Model model, @PathVariable String projectCode) {
        model.addAttribute("project", projectService.findById(projectCode));// we need to populated that project details in the form
        model.addAttribute("managers", userService.findManagers() );
        model.addAttribute("projects", projectService.findAll() );
        return "project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project) {
        // i need to update that project, we need to service, do we have any service
        // we create business  which is updating
        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){

        UserDTO manager = userService.findById("john@cydeo.com");
        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);
        model.addAttribute("projects", projects);
        //now I don't know security portion, id portion so now we put hard codded ("john@cydeo.com")
        // when we do security this information, whenever we log in username and password,
        // system is gonna know who log into system, so we are gonna know fine by ID portion

        return "/manager/project-status";
    }

}
