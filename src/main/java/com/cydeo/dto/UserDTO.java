package com.cydeo.dto;

import com.cydeo.entity.Role;
import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//whatever we see in the UI part in the DTO field
//but whatever you save in the database for example i want to save who create this object,
//I don't see this information in UI
//right now 'who created this object' is entity fields. then is different object.
//That's why we separate this object
//entity package-dto package
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;//unique, in here we use email address for username
    private String password;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
