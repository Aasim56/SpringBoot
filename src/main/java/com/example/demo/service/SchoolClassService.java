package com.example.demo.service;

import com.example.demo.dto.schoolclass.SchoolClassRequestDTO;
import com.example.demo.dto.schoolclass.SchoolClassResponseDTO;
import com.example.demo.dto.student.StudentResponseDTO;
import com.example.demo.entity.SchoolClass;
import com.example.demo.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class SchoolClassService {

    private final SchoolClassRepository repository;

    public SchoolClassService(SchoolClassRepository repository) {
        this.repository = repository;
    }

    public SchoolClassRequestDTO createSchoolClass(SchoolClassRequestDTO dto) {
        SchoolClass schoolClass = new SchoolClass();

        schoolClass.setName(dto.getName());

        SchoolClass savedClass = repository.save(schoolClass);
        return new SchoolClassRequestDTO(
                savedClass.getName()
        );
    }

    public SchoolClassResponseDTO getClassById(@PathVariable int id){

        SchoolClass schoolClass = repository.findById(id)
                .orElseThrow(()
                -> new RuntimeException("Class not found with ID : " +id));

        return new SchoolClassResponseDTO(
                schoolClass.getId(),
                schoolClass.getName(),
                schoolClass.getStudents().stream().map(student
                        -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getAttendance()
                )).toList()
        );
    }
}
