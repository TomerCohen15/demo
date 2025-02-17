package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        Person newPerson = personService.savePerson(person);
        logger.info("added Person: {}", newPerson);
        return newPerson;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @DeleteMapping
    public void deletePerson(@RequestParam("id") UUID id) {
        Person person = personService.getPersonById(id);
        logger.info("deleting Person: {}, with name {}", id, person.getName());
        personService.deletePerson(id);
        logger.info("deleted Person: {}, with name {}", id, person.getName());
    }
}
