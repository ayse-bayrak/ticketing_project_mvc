package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO, Long> {

//   as a developer in this stage, this service is dynamic, because that is business logic
//   whenever you need user stories you're gonna come here and build it.
//   this part is deleted after extends Generic CrudService
//   RoleDTO save(RoleDTO user);
//   RoleDTO findById(Long id);
//   List<RoleDTO> findAll();
//   void deleteById(Long id);

    // this business, it's totally depends on your application needs
    // this part is in the UserService Interface also , and we should create Generic interface
    // it means the same thing is repeating with the different return type of different parameter
    // we can make this into interface generic
    //then what it means this same method I can write it one time and then based on the parameter it is accepting, it can execute

    //part in the UserService Interface
//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    List<UserDTO> findAll();
//    void deleteById(String username);

}
