package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // like @Component - create Bean
public class RoleService extends AbstractMapService<RoleDTO, Long> implements com.cydeo.service.RoleService {
    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role ); // when i need to implement something, it is common, and so we wrote AbstractMapService and we inherited from there
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
}
