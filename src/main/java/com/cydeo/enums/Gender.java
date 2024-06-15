package com.cydeo.enums;

public enum Gender {
   MALE("Male"), FEMALE("Female");
    // IN PROGRESS in application
    // usually in constant is defined with capital letter,
    // but if i want to show in a different way in my application
    // i need to put these are as a value

   private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
