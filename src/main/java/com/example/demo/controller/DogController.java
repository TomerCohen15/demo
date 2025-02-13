package com.example.demo.controller;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    private static final Logger logger = LoggerFactory.getLogger(DogController.class);
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        Dog newDog = dogService.saveDog(dog);
        logger.info("Added Dog: {}", newDog);
        return newDog;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @DeleteMapping
    public void deleteDog(@RequestParam("id") Long id) {
        Dog dog = dogService.getDogById(id);
        logger.info("Deleting Dog: {}, with name {}", id, dog.getName());
        dogService.deleteDog(id);
        logger.info("Deleted Dog with ID: {}", id);
    }
}
