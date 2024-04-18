package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String>{

    //we put here whatever common for all services, if something is unique to user service,
    // go that service and write in that service

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees(); // First I need to put abstract method which is needed in the service and then i implement implementation class
                                   // because i need to be familiar with app structure, service interface and override in the implementation class
//    //this part is deleted after extends Generic CrudService
//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    // if i want to choose certain user, I'm gonna to choose based on the username
//    List<UserDTO> findAll(); // we need to it in the UserList
//    void deleteById(String username);
}
