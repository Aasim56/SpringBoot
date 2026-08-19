package com.example.demo.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDTO {

    @NotBlank(message = "Name is Required")
    private String name;

    @Min(value = 5, message = "Age must be atleast 5")
    @Max(value = 25, message = "Age should not exceed 25")
    private int age;

    @NotBlank(message = "Attendance is mandatory")
    private String attendance;

    public StudentRequestDTO(){

    }
    public StudentRequestDTO(String name, int age, String attendance){
        this.name = name;
        this.age = age;
        this.attendance = attendance;
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
