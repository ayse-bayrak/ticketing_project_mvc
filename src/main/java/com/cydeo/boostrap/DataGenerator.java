package com.cydeo.boostrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//bootstrap meaning is initial something, initial sit the data, load the data

@Component// why i need to @Component? what was the rule where we need to use @Component or What kind of classes it needs to be managed by Spring as an object?
//either use in another class or it is using another class, if one class has a dependency or if this class is going to be used as a dependency some other class we need to use @Component
public class DataGenerator implements CommandLineRunner  {
    //Spring framework gives me CommandLineRunner interface (Functional Interface)

    private final RoleService roleService;  //one class has a dependency
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    //go to role service for example, give me one Bean belongs to Role service injected
    //interface we never put @Component, we put in the implementation
    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        //This run method will execute FIRST BEFORE ANYTHING when you start the application
        //whatever you put inside, it will execute
        // this run method responsibility is whenever this application execute,
        // first this method is executing right away before doing anything
        // how we came to this point? I need to some roles in the application,
        //whenever I start the application, some roles need to be loaded
        //whatever you need it initially some data in the application
        //we are gonna put it here


        //1-one logic==>create some roles and put in the DB (map)

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        //whenever this application execute,
        // first is gonna create this object for me
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        //1-1 adding data base through `related object interface` (in here roleService)

        RoleServiceImpl rs = new RoleServiceImpl();
        rs.save(adminRole);// did I add adminRole objcet in the map, yes
        //everything is okey? Coupling when I do this one, I am doing tight coupling,
        // Spring don't like new keyword because i am creating object by myself, i need to manage this object,
        // if anything needs to change, i need to change, spring does not like this one, this is tight coupling
        // how i am gonna do lose coupling?
        //What kind of Spring Core principle we need to implement here fix this code?
        //IOC our main principle, we need to it. i don't need to control, i must bring to control IOC
        //we need to implement here. What kind of things need to implement?
        //Dependency Injection
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

//        RoleServiceImpl rs = new RoleServiceImpl();// Spring does not love new keyword
//        rs.save(adminRole); // Tight coupling, this structure is bad
        // we need to implement IoC (our main principle)
        // what kind of principle I need to do it-> Dependency injection
        //if you want to use if one classes and another class relationship has
        // if data generator has a some other class create relationship

        //2-the other one logic==> create users and put in the DB(map)

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "Abc1", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "Abc2", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Delisa", "Norre",
                "delisa@cydeo.com",  "Abc3", "Abc3", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "Abc4", "Abc4", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Shaun", "Hayns",
                "shaun@cydeo.com", "Abc5", "Abc5", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth", "Loren",
                "elizebeth@cydeo.com", "Abc6", "Abc6", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria", "Ada",
                "maria@cydeo.com", "Abc7", "Abc7", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill", "Matt",
                "bill@cydeo.com", "Abc8", "Abc8", true, "8881239846", employeeRole, Gender.MALE);

        //2-1 //2-1 adding data base through related object interface (in her userService)
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        // and go on other similar logic for project and task
        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(1L,project1, user8, "Controller", "Request Mapping", Status.IN_PROGRESS, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(2L,project3, user3, "Configuration", "Database Connection", Status.COMPLETE, LocalDate.now().minusDays(12));
        TaskDTO task3 = new TaskDTO(3L,project3, user6, "Mapping", "One-To-Many", Status.COMPLETE, LocalDate.now().minusDays(8));
        TaskDTO task4 = new TaskDTO(4L,project2, user7, "Dependency Injection", "Autowired", Status.IN_PROGRESS, LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);



    }
}
