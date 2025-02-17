package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Animal {

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
