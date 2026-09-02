package com.example.demo.dto.student;

public class StudResDto {

    private Integer id;
    private String name;
    private int age;
    private String attendance;
    private String className;


    public StudResDto() {
    }

    public StudResDto(Integer id, String name, int age, String attendance, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.attendance = attendance;
        this.className = className;

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


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

