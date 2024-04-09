package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService <T, ID>  {

    //we will make Generic Service interface because these methods, certain businesses
    //like save user, save project, save manager, save employee, save product
    //these are all same thing, only thing what is changing? whatever you try to save
    //in this case Role user or Employee employee object or user object or task object
    // only parameters is changing, so i can just generic design
    //I need to convert save method to Generic,
    //UserDTO save(UserDTO user);

    T save(T user);
    T findById(ID username);
    List<T> findAll();/** how is gonna find it, so next stage is : we gonna create those implementation impl*/
    void deleteById(ID username);



}
