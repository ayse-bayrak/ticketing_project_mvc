package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // like @Component - create Bean
public class UserServiceImpl extends AbstractMapService<UserDTO,String>implements UserService {
    @Override
    public UserDTO save(UserDTO user) {
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


}
