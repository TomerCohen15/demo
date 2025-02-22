package com.example.demo.unit;


import com.example.demo.entity.Cat;
import com.example.demo.repository.CatRepository;
import com.example.demo.service.CatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatServiceUnitTest {

    @Mock
    private CatRepository catRepository; // Mock the repository layer

    @InjectMocks
    private CatService catService; // Service being tested

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testGetAllCats() {
        // Given
        Cat cat1 = new Cat();
        cat1.setName("Whiskers");
        cat1.setBreed("Siamese");
        cat1.setAge(3);

        Cat cat2 = new Cat();
        cat2.setName("Garfield");
        cat2.setBreed("Tabby");
        cat2.setAge(5);

        List<Cat> cats = Arrays.asList(cat1, cat2);

        when(catRepository.findAll()).thenReturn(cats); // Mock repository behavior

        // When
        List<Cat> retrievedCats = catService.getAllCats();

        // Then
        assertNotNull(retrievedCats);
        assertEquals(2, retrievedCats.size());
        assertEquals("Whiskers", retrievedCats.get(0).getName());
        assertEquals("Garfield", retrievedCats.get(1).getName());

        verify(catRepository, times(1)).findAll();
    }

}
