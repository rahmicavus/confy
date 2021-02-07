package com.pluralsight.confy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Registration {

    @NotNull
    @Min(2)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Registation{" +
                "name='" + name + '\'' +
                '}';
    }
}
