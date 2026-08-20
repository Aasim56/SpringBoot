package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String passport_name;

    @OneToOne(mappedBy = "passport")
    private Student students;

    public Passport(){

    }

    public Passport(Integer id, String passport_name){
        this.passport_name = passport_name;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return passport_name;
    }

    public void setName(String passport_name) {
        this.passport_name = passport_name;
    }


    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }
}
