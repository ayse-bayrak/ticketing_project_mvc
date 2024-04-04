package com.cydeo.dto;

import com.cydeo.entity.Role;
import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//whatever we see in the UI part in the DTO field
//but whatever you save in the database for exmaple i want to save who create this object,
//I don't see this information in UI
//right now 'who created this object' is entity fields. then is different object.
//That's why we separate this object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
