package com.rOushAn.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    //Setting freePass to NotNull, but we cannot use primitive data types int with @NotNull because it returns null which
    //is an object for this we need to convert int to Integer.
    @NotNull(message = "is required")
    @Min(value = 0, message = "minimum value must be greater than 0")
    @Max(value = 10, message = "maximum value must be smaller than 10")
//    private int freePass;
    private Integer freePass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}$", message = "Only 5 chars/digits are allowed")
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
