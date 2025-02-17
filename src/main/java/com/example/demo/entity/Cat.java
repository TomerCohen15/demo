package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cat extends Animal {
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
