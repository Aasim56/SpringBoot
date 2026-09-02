package com.example.demo.service;

import com.example.demo.dto.passport.PassportRequestDTO;
import com.example.demo.dto.passport.PassportResponseDTO;
import com.example.demo.dto.student.StudentResponseDTO;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;
import com.example.demo.repository.PassportRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public PassportRequestDTO createPassport(PassportRequestDTO dto){

        Passport passport = new Passport();

        passport.setName(dto.getPassport_name());
        Passport savedPassport = passportRepository.save(passport);
        return new PassportRequestDTO(
                savedPassport.getName()
        );
    }

}
