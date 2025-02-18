package com.example.demo.service;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog saveDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public void deleteDog(UUID id) {
        dogRepository.deleteById(id);
    }

    public Dog getDogById(UUID id) {
        return dogRepository.getDogById(id).orElseThrow(() -> new AnimalNotFoundException("Dog with ID " + id + " not found"));
    }

}
