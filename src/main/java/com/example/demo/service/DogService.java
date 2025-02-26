package com.example.demo.service;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import org.apache.commons.lang3.StringUtils;
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

    public Dog updateDog(Dog dog) {
        Dog dogToUpdate = getDogById(dog.getId());
        if (StringUtils.isNotBlank(dog.getName())) {
            dogToUpdate.setName(dog.getName());
        }
        if (dog.getAge() != 0 && dog.getAge() != dogToUpdate.getAge()) {
            dogToUpdate.setAge(dog.getAge());
        }
        if (dog.getGender() != null) {
            dogToUpdate.setGender(dog.getGender());
        }
        if (dog.getBarkLoudness() != 0) {
            dogToUpdate.setBarkLoudness(dog.getBarkLoudness());
        }
        if (dog.getBreed() != null) {
            dogToUpdate.setBreed(dog.getBreed());
        }
        return dogRepository.save(dogToUpdate);
    }
}
