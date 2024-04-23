package com.cydeo.dto;

import com.cydeo.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {


    //in the UI there is not unique thing like id, in these case I should add unique fields to my object fields
    // and in the UI Task List we need to some fields like taskStatus and assignedDate; and I should add these fields also

    // what i need to convert? whatever you see here not String, it is not gonna do it basically,
    //and we need to convert two things, now we have UserDTO converter and need to ProjectDTO converter also

    private Long id; // added, I am just adding by my self

    @NotNull
    private ProjectDTO project;

    @NotNull
    private UserDTO assignedEmployee;

    @NotNull
    private String taskSubject;

    @NotNull
    private String taskDetails;

    private Status taskStatus; // added
    private LocalDate assignedDate; // added

}
