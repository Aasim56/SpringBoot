package com.example.demo.dto.Subject;


public class StudentResponsedto {

    private int id;
    private String name;

    public StudentResponsedto(){}

    public StudentResponsedto(int id, String name){
        this.id = id;
        this.name = name;
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
}
