package com.cydeo.converter;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding //Accepting one string and is returning role dto and it's gonna do it for you automatically

// if you try to bring another object inside usually drop down you need converter.
//For example in here Choose a Role dropdown and Role is object and we need Converter (Day11-Spring-2:24)
//THis is a good challenge, if anybody asks you can, can you please describe one of the  challenge you face by doing application
// if I have one object inside another object i need converter

public class RoleDtoConverter implements Converter<String, RoleDTO>{
    private final RoleService roleService;

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        if(source == null || source.equals("")){ // 'Select' option -> ""
            return null; // if user leaved it empty sending me empty instead of something selection,
            //and captured by @NotNull above the RoleDTO
        }
        return roleService.findById(Long.parseLong(source));
    }
}
