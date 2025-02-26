package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
public class Dog extends Animal {
    @Min(1)
    @Max(10)
    private int barkLoudness;

    public Dog(String name, String breed, int age, Gender gender, int barkLoudness) {
        super(name, breed, age, gender);
        this.barkLoudness = barkLoudness;
    }

    public Dog() {
        super();

    }

    public int getBarkLoudness() {
        return barkLoudness;
    }

    public void setBarkLoudness(int barkLoudness) {
        this.barkLoudness = barkLoudness;
    }

    @Override
    public String toString() {
        return super.toString() + "barkLoudness=" + barkLoudness;
    }
}
