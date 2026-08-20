package com.example.demo.controller;

import com.example.demo.dto.schoolclass.SchoolClassRequestDTO;
import com.example.demo.dto.schoolclass.SchoolClassResponseDTO;
import com.example.demo.service.SchoolClassService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }


    @PostMapping("/classes")
    public SchoolClassRequestDTO createSchoolClass(@RequestBody SchoolClassRequestDTO dto){
        return schoolClassService.createSchoolClass(dto);
    }

    @GetMapping("/classes/{id}")
    public SchoolClassResponseDTO getStudentByClassId(@PathVariable int id){
        return schoolClassService.getClassById(id);
    }

}
