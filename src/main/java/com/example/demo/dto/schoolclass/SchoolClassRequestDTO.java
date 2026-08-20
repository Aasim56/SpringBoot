package com.example.demo.dto.schoolclass;

public class SchoolClassRequestDTO {



private String name;

public SchoolClassRequestDTO(){}

public SchoolClassRequestDTO(String name){

    this.name = name;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
