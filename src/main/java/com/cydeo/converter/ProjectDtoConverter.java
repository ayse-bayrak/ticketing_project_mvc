package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding we do not need to anymore, Spring recognize it also
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {
    final ProjectService projectService;

    public ProjectDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        return projectService.findById(source);
    }
}
