package com.cydeo.boostrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner  {
    //SpringBoot gives me CommandLineRunner interface

    private final RoleService roleService;
    private final UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        //This run method will execute FIRST BEFORE ANYTHING when you start the application
        //whatever you put inside, it will execute
        // this run method responsibility is whenever this application execute,
        // first this method is executing right away before doing anything
        // how we came to this point? I need to some roles in the application,
        //whenever I start the application, some roles need to be loaded
        //create some roles and put in the DB (map)
        //whatever you need it initially some data in the application
        //we are gonna put it here

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        // adding data base through related object interface (in her roleService)
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

//        RoleServiceImpl rs = new RoleServiceImpl();// Spring does not love new keyword
//        rs.save(adminRole); // Tight coupling, this structure is bad
        // we need to implement IoC (our main principle)
        // what kind of principle I need to do it-> Dependency injection
        //if you want to use if one classes and another class relationship has
        // if data generator has a some other class create relationship

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


    }
}
