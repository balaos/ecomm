package com.sample.ecomm.others.validator;

import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull(message = "Name cannot be null")
    @CustomValidator(message = "Name must start with an uppercase letter")
    private String name;

    // Constructor, Getter & Setter
    public UserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
