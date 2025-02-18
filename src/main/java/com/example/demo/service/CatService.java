package com.example.demo.service;

import com.example.demo.exceptions.AnimalNotFoundException;
import com.example.demo.entity.Cat;
import com.example.demo.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public void deleteCat(UUID id) {
        catRepository.deleteById(id);
    }

    public Cat getCatById(UUID id) { return catRepository.getCatById(id).orElseThrow(() -> new AnimalNotFoundException("Cat with ID " + id + " not found")); }

}
