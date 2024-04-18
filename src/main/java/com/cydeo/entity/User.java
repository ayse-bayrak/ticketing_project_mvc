package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@AllArgsConstructor
//Lombok doesn't create Constructor initialization for the parent Fields
//That's why we need to create constructor manual if class is extends something(class or interface)
@Data
@NoArgsConstructor
//@AllArgsConstructor we don't put AllArgConstructor, because if i have super class,
// lombok does not create this contructor initialization for the parent fields
//that's why we need to create manually constructor
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled; // this structure i will do in the security
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateTime, Long lastUpdatedUserId, String firstName, String lastName, String userName, String password, boolean enabled, String phone, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateTime, lastUpdatedUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
