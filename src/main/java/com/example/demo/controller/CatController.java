package com.example.demo.controller;

import com.example.demo.entity.Cat;
import com.example.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    private static final Logger logger = LoggerFactory.getLogger(CatController.class);
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        Cat newCat = catService.saveCat(cat);
        logger.info("added Cat: {}", newCat);
        return newCat;
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @DeleteMapping
    public void deleteCat(@RequestParam("id") Long id) {
        Cat cat = catService.getCatById(id);
        logger.info("deleting Cat: {}, with name {}", id, cat.getName());
        catService.deleteCat(id);
        logger.info("deleted Cat: {}, with name {}", id, cat.getName());
    }
}
