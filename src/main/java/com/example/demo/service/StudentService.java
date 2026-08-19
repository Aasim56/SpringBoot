package com.example.demo.service;


import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entity.SchoolClass;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.SchoolClassRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StudentService {

    private final SchoolClassRepository schoolClassRepository;



    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto, int classId) {

        SchoolClass schoolClass = schoolClassRepository.findById(classId).orElseThrow(()-> new RuntimeException("Class not found with ID : " + classId));

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setAttendance(dto.getAttendance());
        student.setSchoolClass(schoolClass);

        Student savedStudent = studentRepository.save(student);

        StudentResponseDTO responseDTO = new StudentResponseDTO();

        responseDTO.setId(savedStudent.getId());
        responseDTO.setName(savedStudent.getName());
        responseDTO.setAge(savedStudent.getAge());
        responseDTO.setAttendance(savedStudent.getAttendance());
        return responseDTO;
    }

   public List<StudentResponseDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        return students.stream().map(student ->
                new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getAttendance()
                        )).toList();
   }
    public StudentResponseDTO getStudentById(int id){
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new StudentNotFoundException("Student not found with id " + id));

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getAttendance()
        );
    }

    public void deleteStudent(int id){

            studentRepository.findById(id).orElseThrow(()
                    -> new StudentNotFoundException("Student not found with id " + id) );
            studentRepository.deleteById(id);
    }

    public StudentResponseDTO updateStudent(int id, StudentRequestDTO dto){

        Student student = studentRepository.findById(id).orElseThrow(()
                -> new StudentNotFoundException("Student not found with id " + id));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setAttendance(dto.getAttendance());
        Student updatedStudent = studentRepository.save(student);

        return new StudentResponseDTO(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getAge(),
                updatedStudent.getAttendance()
                );

        }



    public List<Student> getStudentByName(String name){
       return studentRepository.findByName(name);

    }
    public List<Student> getStudentByAge(int age){
        return studentRepository.findByAge(age);
    }
    public List<Student> getStudentByNameAndAge(String name, int age){
        return studentRepository.findByNameAndAge(name,age);
    }

    @Transactional
    public Student updateStudentTransactional(int id, String name, int age, String attendance) {

        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found with id " + id));

        student.setName(name);
        student.setAge(age);
        student.setAttendance(attendance);

        return student;
    }
    public List<StudentResponseDTO> getStudentOlderThan(int age) {
        List<Student> students = studentRepository.findStudentsOlderThan(age);

        return students.stream().map(student
                -> new StudentResponseDTO(
                        student.getId(),
                student.getName(),
                student.getAge(),
                student.getAttendance()
        )).toList();

    }

    public List<StudentResponseDTO> searchByName(String name){
        List<Student> Students = studentRepository.searchByName(name);

        return studentRepository.searchByName(name)
                .stream()
                .map(student
                -> new StudentResponseDTO(
                        student.getId(),
                student.getName(),
                student.getAge(),
                student.getAttendance()
        ))
                .toList();
    }

    public List<StudentResponseDTO> searchByNameAndAge(String name, int age){
        List<Student> students = studentRepository.searchByNameAndAge(name, age);

        return studentRepository.searchByNameAndAge(name, age)
                .stream()
                .map(student
                        -> new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getAttendance()
        ))
                .toList();
    }


    @Transactional
    public int updateAttendance(int id, String attendance){
        return studentRepository.updateAttendance(id, attendance);
    }

    @Transactional
    public int deleteStudentById(int id){
        return studentRepository.deleteStudentById(id);
    }

    public List<StudentResponseDTO> getStudentOlderThanNative (int age){
       return studentRepository.findStudentsOlderThanNative(age)
                .stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getAttendance()
                ))
                .toList();
    }


    @Transactional
    public int updateAttendanceNative(String attendance, int id ){
        return studentRepository.updateAttendanceNative(attendance, id);
    }

}

