package com.example.demo.dto.schoolclass;

import com.example.demo.dto.student.StudentResponseDTO;

import java.util.List;

public class SchoolClassResponseDTO {
    private int id;
    private String name;
    private List<StudentResponseDTO> students;


    public SchoolClassResponseDTO(){

    }

    public SchoolClassResponseDTO(int id, String name, List<StudentResponseDTO> students){
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentResponseDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentResponseDTO> students) {
        this.students = students;
    }
}
