package com.example.demo.controller;

import com.example.demo.dto.Subject.SubjectResponseDTO;
import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }

    @GetMapping("/subjects/{id}")
    public SubjectResponseDTO subjectById(@PathVariable int id){
        return subjectService.getSubjectById(id);
    }
}
