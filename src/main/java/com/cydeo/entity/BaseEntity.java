package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//whatever we see in the UI part in the DTO field
//but whatever you save in the database for example i want to save who create this object,
//I don't see this information in UI
//right now 'who created this object' is entity fields. then is different object.
//That's why we separate this object
// and we create Base entity for the not existing UI part(User)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private Long id;
    private LocalDateTime insertDateTime;
    private Long insertUserId;
    private LocalDateTime lastUpdateTime;
    private Long lastUpdatedUserId;
}
