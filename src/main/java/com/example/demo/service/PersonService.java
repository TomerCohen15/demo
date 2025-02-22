package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }

    public Person getPersonById(UUID id) { return personRepository.getPersonById(id).orElseThrow(() ->
            new PersonNotFoundException("Person with id: " + id + " not found"));
    }

    public Person updatePerson(@RequestBody Person person) {
        Person personToUpdate = getPersonById(person.getId());

        if (StringUtils.isNotBlank(person.getName())) {
            personToUpdate.setName(person.getName());
        }
        if (person.getAge() != 0 && person.getAge() != personToUpdate.getAge()) {
            personToUpdate.setAge(person.getAge());
        }
        if (person.getGender() != null) {
            personToUpdate.setGender(person.getGender());
        }
        if (StringUtils.isNotBlank(person.getAddress())) {
            personToUpdate.setAddress(person.getAddress());
        }
        return personRepository.save(personToUpdate);
    }
}
