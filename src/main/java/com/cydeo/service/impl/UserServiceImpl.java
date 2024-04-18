package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // like @Component - create Bean
public class UserServiceImpl extends AbstractMapService<UserDTO,String>implements UserService {
    @Override
    public UserDTO save(UserDTO user) { // if I am implementing it(UserServiceImpl) interface, meaning i am making contract, i need to give implementation for all the abstract method inside
        return super.save(user.getUserName(), user ); // when i need to implement something, it is common, and so we wrote AbstractMapService and we inherited from there
    }

    @Override
    public UserDTO findById(String username) {
        return super.findById(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String username) {
     super.deleteById(username);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }


    @Override
    public List<UserDTO> findManagers() {
        return findAll().stream().filter(p->p.getRole().getId()==2).collect(Collectors.toList());

    }

    @Override
    public List<UserDTO> findEmployees() {
        //return findAll().stream().filter(p->p.getRole().getDescription().equalsIgnoreCase("employee")).collect(Collectors.toList()); // it can be like this
        return findAll().stream().filter(p->p.getRole().getId()==3).collect(Collectors.toList());
    }
}
