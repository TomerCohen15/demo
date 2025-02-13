package com.example.demo.service;

import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }

    public Dog getDogById(Long id) { return dogRepository.getDogById(id).get(); }

}
