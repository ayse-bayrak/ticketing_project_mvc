package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService <T, ID>  {

    /**we will make Generic this interface
    //I need to convert save method to Generic
    //UserDTO save(UserDTO user); */

    T save(T user);
    UserDTO findById(String username);
    T findById(ID username);
    List<T> findAll();/** how is gonna find it, so next stage is : we gonna create those implementation impl*/
    void deleteById(ID username);
}
