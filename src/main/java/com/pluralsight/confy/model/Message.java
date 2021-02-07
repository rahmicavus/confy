package com.pluralsight.confy.model;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
