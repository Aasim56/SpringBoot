package com.example.demo.controller;

import com.example.demo.entity.SchoolClass;
import com.example.demo.repository.SchoolClassRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolClassController {
    private final SchoolClassRepository repository;

    public SchoolClassController(SchoolClassRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/classes")
    public SchoolClass createschoolclass(@RequestBody SchoolClass schoolClass){
        return repository.save(schoolClass);
    }

}
