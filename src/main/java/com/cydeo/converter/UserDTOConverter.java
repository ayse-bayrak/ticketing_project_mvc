package com.cydeo.converter;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
//if any class is trying to inject has a relationship what this class needs to have it, @Component
@Component
@ConfigurationPropertiesBinding // whenever we use Converter belongs to Spring package, it is doing automatically for you
//so we don't need to even put that annotation
public class UserDTOConverter implements Converter<String, UserDTO> {
    //what is the logic? you give me the String username, i will go to database and
    // i will bring the object that you are looking for.we need to use the service, because I wrote the service finfById method

    private final UserService userService;

    public UserDTOConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        return userService.findById(source);
    }
}
