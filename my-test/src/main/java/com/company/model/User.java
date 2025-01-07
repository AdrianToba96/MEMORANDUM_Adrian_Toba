package com.company.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class User {
    @NotNull(message = "El peso no puede ser nulo.")
    @Min(value = 1, message = "El peso debe ser mayor a 0.")
    private Double weight;

    @NotNull(message = "La altura no puede ser nula.")
    @Min(value = 1, message = "La altura debe ser mayor a 0.")
    private Double height;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}