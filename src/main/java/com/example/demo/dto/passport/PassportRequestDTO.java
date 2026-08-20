package com.example.demo.dto.passport;

public class PassportRequestDTO {



    private String passport_name;

    public PassportRequestDTO(){}

    public PassportRequestDTO(String passport_name){
        this.passport_name = passport_name;
    }

    public String getPassport_name() {
        return passport_name;
    }

    public void setPassport_name(String passport_name) {
        this.passport_name = passport_name;
    }

}
