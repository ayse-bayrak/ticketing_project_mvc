package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // like  - main job is to create Bean, @Component is gonna be in the tree different shape @Controller, @Service.. third one will come soon :) -->Repository :)
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements com.cydeo.service.RoleService {
   // firstly I apply RoleServiceImpl implement RoleService for override method of abstract method in the service and then I use extends AbstractMapService for inherit implementation
    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role ); // when i need to implement something,
        // it is common, and so we wrote AbstractMapService, it has the implementation,
        // call the method here and I inherited from there via super.method
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();// where is implementation in AbstractMapService
        //how we can call a method belongs tp parents. super keyword
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(), object);
    }


}
