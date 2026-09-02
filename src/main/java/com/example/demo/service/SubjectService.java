package com.example.demo.service;

import com.example.demo.dto.Subject.StudentResponsedto;
import com.example.demo.dto.Subject.SubjectResponseDTO;
import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    public Subject createSubject(Subject subject){
         return subjectRepository.save(subject);
    }

    public SubjectResponseDTO getSubjectById(int id){

        Subject subject = subjectRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Subject not found"));
        List<StudentResponsedto> students = subject.getStudents().stream().map(student -> new StudentResponsedto(
                student.getId(),
                student.getName()
        )).toList();

         return new SubjectResponseDTO(
                 subject.getId(),
                 subject.getName(),
                 students
         );

    }
}
