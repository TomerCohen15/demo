package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Animal {

    private String name;
    private String breed;
    private int age;
    private Gender gender;

    public Dog(String name, String breed, int age, Gender gender) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    public Dog() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + getId() +
//                ", type='" + getType() + '\'' +
                ", timestamp=" + getTimestamp() +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }
}
