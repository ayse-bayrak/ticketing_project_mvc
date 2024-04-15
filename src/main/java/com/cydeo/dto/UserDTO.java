package com.cydeo.dto;

import com.cydeo.entity.Role;
import com.cydeo.enums.Gender;
import jakarta.validation.constraints.*;
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

    @NotBlank// first name can not be blank
    @Size(max=15, min=2)
    private String firstName;

    @NotBlank
    @Size(max=15, min=2)
    private String lastName;

    @NotBlank
    @Email
    private String userName;//unique, in here we use email address for username

    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;

    @NotNull
    private String confirmPassword;

    private boolean enabled; // i leave it empty because i m not gonna touch anything related with enabled
    @NotBlank
    @Pattern(regexp = "^\\d{10}$") // should have 10 characters and it should only numbers
    private String phone;

    //@NotBlank, NotEmpty, these are for only String fields but RoleDTO is not a String it is an object, we are using NotNull for object

    @NotNull
    private RoleDTO role;

    @NotNull
    private Gender gender;
}
