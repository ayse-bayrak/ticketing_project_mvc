package com.cydeo.dto;

import com.cydeo.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

        @NotBlank
        private String projectName;

        @NotBlank
        private String projectCode;

        @NotNull
        private UserDTO assignedManager;

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate startDate;

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate endDate;

        @NotBlank
        private String projectDetail;

        private Status projectStatus;

        private int completeTaskCounts; // I added these two fields because my project-status htm needs
        private int unfinishedTaskCounts;

        //since data generator complain because of all args constructor
        // we need to another constructor except added fields,
        // I need able to figure out these two fields so we can create one more constructor
        public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
                this.projectName = projectName;
                this.projectCode = projectCode;
                this.assignedManager = assignedManager;
                this.startDate = startDate;
                this.endDate = endDate;
                this.projectDetail = projectDetail;
                this.projectStatus = projectStatus;
        } // this constructor where am I using? Project Create page
        // allArgConstructor, I am using project-status page to display Project List table
}

