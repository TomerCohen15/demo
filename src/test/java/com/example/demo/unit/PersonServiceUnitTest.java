package com.example.demo.unit;


import com.example.demo.entity.Cat;
import com.example.demo.entity.Person;
import com.example.demo.repository.CatRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.CatService;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.entity.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceUnitTest {

    @Mock
    private PersonRepository personRepository; // Mock the repository layer

    @InjectMocks
    private PersonService personService; // Service being tested

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testGetAllCats() {
        Person expectedPerson = new Person();
        expectedPerson.setName("John");
        expectedPerson.setAddress("Main street 321");
        expectedPerson.setAge(32);
        expectedPerson.setGender(MALE);
        expectedPerson.setPhoneNumber("1234567890");
        // Given
        Person currentPerson = new Person();
        currentPerson.setName("John");
        currentPerson.setAddress("Main street 123");
        currentPerson.setAge(32);
        currentPerson.setGender(MALE);
        currentPerson.setPhoneNumber("1234567890");

        Person personUpdate = new Person();
        personUpdate.setAddress("Main street 321");
        personUpdate.setName("");

        when(personRepository.save(currentPerson)); // Mock repository behavior

        // When
        Person updatedPerson = personService.updatePerson(personUpdate);

        // Then
        assertNotNull(updatedPerson);
        assertTrue(updatedPerson.equals(expectedPerson));
    }

}
