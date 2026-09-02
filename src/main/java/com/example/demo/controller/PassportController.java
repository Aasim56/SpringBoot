package com.example.demo.controller;

import com.example.demo.dto.passport.PassportRequestDTO;
import com.example.demo.dto.passport.PassportResponseDTO;
import com.example.demo.entity.Passport;
import com.example.demo.service.PassportService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassportController {


    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @PostMapping("/passports")
    public PassportRequestDTO createPassport(@RequestBody PassportRequestDTO dto) {
        return passportService.createPassport(dto);
    }


}
