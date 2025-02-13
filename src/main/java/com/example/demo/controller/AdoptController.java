package com.example.demo.controller;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;
import com.example.demo.service.AdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/adopts")
public class AdoptController {
    private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
    private final AdoptService adoptService;

    @Autowired
    public AdoptController(AdoptService adoptService) {
        this.adoptService = adoptService;
    }

    @PostMapping
    public Person adopt(@RequestBody Person adopter, @RequestParam("animalId") long animalId) {
        Person newPerson = adoptService.savePerson(adopter);
        Animal animal = adoptService.updateAnimalAdoptedBy(animalId, newPerson);
        logger.info("Person {} adopted Animal {}", newPerson.getName(), animal.getId());
        return newPerson;
    }

}
