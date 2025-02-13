package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    private Person adoptedBy = null;
    private LocalDateTime adoptedDate;

//    private String type;
    private LocalDateTime timestamp;

    public Animal() {}

    public Animal(String name, String breed, int age, Gender gender){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    public Animal(String name, String breed, int age, Gender gender, Person adoptedBy, LocalDateTime adoptedDate) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.adoptedBy = adoptedBy;
        this.adoptedDate = adoptedDate;
    }

//    public Animal(String type) {
//        this.type = type;
//    }

    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public Person getAdoptedBy() {
        return adoptedBy;
    }

    public void setAdoptedBy(Person adoptedBy) {
        this.adoptedBy = adoptedBy;
    }

//    public String getType() {
//        return type;
//    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
//                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public LocalDateTime getAdoptedDate() {
        return adoptedDate;
    }

    public void setAdoptedDate(LocalDateTime adoptedDate) {
        this.adoptedDate = adoptedDate;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
