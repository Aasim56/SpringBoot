package com.example.demo.dto.Subject;

import com.example.demo.entity.Student;

import java.util.List;

public class SubjectResponseDTO {
    private int id;
    private String name;
    private List<Student> students;

    public SubjectResponseDTO(Integer id, String name, List<StudentResponsedto> students){}

    public SubjectResponseDTO(int id, String name, List<Student> students){
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

    public List<Student> getDto() {
        return students;
    }

    public void setDto(List<Student> students) {
        this.students = students;
    }
}
