package com.example.demo.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.persistence.Entity;

@Entity
public class Cat extends Animal {
    @Min(1)
    @Max(10)
    private int clawSharpness;

    public Cat(String name, String breed, int age, Gender gender, int clawSharpness) {
        super(name, breed, age, gender);
        this.clawSharpness = clawSharpness;
    }

    public Cat() {
        super();
    }

    public int getClawSharpness() {
        return clawSharpness;
    }

    public void setClawSharpness(int clawSharpness) {
        this.clawSharpness = clawSharpness;
    }

    @Override
    public String toString() {
        return super.toString() + "clawSharpness=" + clawSharpness;
    }
}
