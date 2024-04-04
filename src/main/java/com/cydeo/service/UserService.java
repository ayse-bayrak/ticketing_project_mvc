package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String>{


//    //this part is deleted after extends Generic CrudService
//    UserDTO save(UserDTO user);
//    UserDTO findById(String username);
//    // if i want to choose certain user, I'm gonna to choose based on the username
//    List<UserDTO> findAll(); // we need to it in the UserList
//    void deleteById(String username);
}
