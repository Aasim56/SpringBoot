package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

//    DEPENDENCY INJECTION------------------------------------------
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


//    CONTROLLER FOR ADDING STUDENT-----------------------------------
    @PostMapping("/students")
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO dto, @RequestParam int classId) {
        return studentService.addStudent(dto, classId);
    }

//    CONTROLLER FOR VIEWING ALL STUDENTS-----------------------------
    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

//    CONTROLLER FOR VIEWING STUDENT BY ID------------------------------
    @GetMapping("/student/{id}")
    public StudentResponseDTO getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

//    CONTROLLER FOR DELETING STUDENT BY ID------------------------------
//    before adding global exception i used responseStatus here, but later i removed it as it is applied to all by globalExceptionHandler
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
          studentService.deleteStudent(id);
        return "Student deleted successfully";

    }
//  CONTROLLER FOR UPDATING STUDENT BY ID
    @PutMapping("/students/{id}")
    public StudentResponseDTO updateStudent(@Valid @PathVariable int id,
                                            @RequestBody StudentRequestDTO dto){
        return studentService.updateStudent(id,dto);


    }

//    CONTROLLER FOR VIEWING STUDENT BY NAME
    @GetMapping("/students/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

//    CONTROLLER FOR VIEWING STUDENT BY AGE
    @GetMapping("/students/age/{age}")
    public List<Student> getStudentByAge(@PathVariable int age){
        return studentService.getStudentByAge(age);
    }


//    CONTROLLER FOR VIEWING STUDENT BY NAME &  AGE
    @GetMapping("/students/name-age/{name}/{age}")
    public List<Student> getStudentByNameAndAge(@PathVariable String name, @PathVariable int age){
        return studentService.getStudentByNameAndAge(name, age);
    }
//  USING TRANSACTION ANNOTATION HERE WHICH COMMITS ONLY WHEN IT IS CORRECT OR IT ROLLBACKS
    @PutMapping("/student/transaction/{id}")
    public Student updateStudentTransaction(@PathVariable int id,
                                           @RequestParam String name,
                                           @RequestParam int age,
                                            @RequestParam String attendance){

        return studentService.updateStudentTransactional( id,name, age, attendance);
    }

    @GetMapping("/student/age/{age}")
    public List<StudentResponseDTO> getStudentOlderThan(@PathVariable int age){
        return studentService.getStudentOlderThan(age);
    }

    @GetMapping("/student/name/{name}")
    public List<StudentResponseDTO> searchByName(@PathVariable String name){
        return studentService.searchByName(name);
    }

    @GetMapping("/student/search/{name}/{age}")
    public List<StudentResponseDTO> searchByNameAndAge(@PathVariable String name,@PathVariable int age){
        return studentService.searchByNameAndAge(name, age);
    }

    @PutMapping("/students/{id}/attendance")
    public String updateAttendance(@PathVariable int id,
    @RequestParam String attendance){

        int updated = studentService.updateAttendance(id, attendance);

        if (updated == 0)return "Student not found";

        return "Attendance updated Successfully";
    }

    @DeleteMapping("/students/{id}")
    public String deletedStudent(@PathVariable int id){
        int deleted = studentService.deleteStudentById(id);

        if (deleted == 0)return "Student not found";
        return "Student deleted Successfully";
    }

    @GetMapping("/Students/native/age/{age}")
    public List<StudentResponseDTO> getStudentOlderThanNative(@PathVariable int age){
        return studentService.getStudentOlderThanNative(age);
    }

    @PutMapping("/student/native/id/{id}/attendance")
    public String updateAttendanceNative(
            @PathVariable int id,
            @RequestParam String attendance){
        int updated = studentService.updateAttendance(id, attendance);

        if (updated == 0) return "Student not found";
        return "Student updated successfully";
    }

}
