package com.example.demo.dto;

public class StudentResponseDTO {
    private Integer id;
    private String name;
    private int age;
    private String attendance;
    public StudentResponseDTO(){

    }
    public StudentResponseDTO(Integer id, String name, int age, String attendance){
        this.id = id;
        this.name = name;
        this.age = age;
        this.attendance = attendance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
