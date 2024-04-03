package com.cydeo.enums;

public enum Gender {
   MALE("Male"), FEMALE("Female"); // IN PROGRESS in application

   private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
