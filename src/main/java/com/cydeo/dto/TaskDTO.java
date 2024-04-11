package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    //in the UI there is not unique thing, in these case I should add unique fields to my object fields
    // what i need to convert? whatever you see here not String, it is not gonna do it basically,
    //and we need to convert two things, now we have UserDTO converter and need to ProjectDTO converter also
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetails;
    private Status taskStatus;
    private LocalDate assignedDate;

}
