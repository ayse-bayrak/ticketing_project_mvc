package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/create";
    }

    @PostMapping("/create")
    //public String insertTask(@ModelAttribute("task") TaskDTO task){ even if we don't use @ModelAttribute anymore, Spring knows
    public String insertTask(TaskDTO task){

       taskService.save(task);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){ // since i use '/' in the endpoint, i need to pathVariable
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }


//    @PostMapping("/update/{id}")
//    public String updateTask(@PathVariable("id") Long id, TaskDTO task) {
//        task.setId(id);
//        taskService.update(task);
//        return "redirect:/task/create";
//    }

    @PostMapping("/update/{id}") // if you are using the same name, it is doing the job automatically for you, you don't need to path variable
    public String updateTask(TaskDTO task) {
        taskService.update(task);
        return "redirect:/task/create";
    }

    @GetMapping("/employee/pending-tasks") // /task endpoint is coming from the RequestMapping from the top of class
    public String employeePendingTask(Model model){

//        UserDTO employee = userService.findById("elizebeth@cydeo.com");
//        model.addAttribute("tasks", taskService.findTasksByEmployee(employee));
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));
        return "/task/pending-tasks";
    }

    @GetMapping("/employee/edit/{id}")
    public String EmployeeEditTask(@PathVariable Long id, Model model){

        model.addAttribute("task", taskService.findById(id));
//        model.addAttribute("projects", projectService.findAll());
//        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE)); // we didn't give Complete it is archive there is no need update

      return "/task/status-update";
    }

    @PostMapping("/employee/update/{id}")
    public String EmployeeUpdateTask(TaskDTO task) {
        taskService.updateStatus(task);
        return "redirect:/task/employee/pending-tasks";
    }

    @GetMapping("/employee/archive")
    public String employeeArchivedTasks(Model model){

        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETE));
        return "/task/archive";
    }


}
