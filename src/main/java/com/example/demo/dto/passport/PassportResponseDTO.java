package com.example.demo.dto.passport;

import com.example.demo.dto.student.StudentResponseDTO;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;
import com.example.demo.repository.PassportRepository;

import java.util.HashMap;
import java.util.List;

public class PassportResponseDTO {

    private int id;
    private String passport_name;
    private List<StudentResponseDTO> students;

    public PassportResponseDTO(){}

    public PassportResponseDTO(int id, String passport_name, List<StudentResponseDTO> students){
        this.id = id;
        this.passport_name = passport_name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport_name() {
        return passport_name;
    }

    public void setPassport_name(String passport_name) {
        this.passport_name = passport_name;
    }

    public List<StudentResponseDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponseDTO> students) {
        this.students = students;
    }
}
