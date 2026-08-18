package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    List<Student> findByAge(int age);
    List<Student> findByNameAndAge(String name, int age);
//-----------------------------------------------------------------

    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(@Param("age")int age);
//-----------------------------------------------------------------
    @Query(""" 
    SELECT s FROM Student s WHERE s.name LIKE %:name%
    """)
    List<Student> searchByName(@Param("name") String name);
//-----------------------------------------------------------------

    @Query("""
        SELECT s FROM Student s WHERE s.name = :name AND s.age = :age
        """)
    List<Student> searchByNameAndAge(@Param("name") String name,
                                     @Param("age") int age);
//-----------------------------------------------------------------


    @Modifying
    @Query("""
        UPDATE Student s SET s.attendance = :attendance WHERE s.id = :id
        """)
    int updateAttendance(@Param("id")int id,
                         @Param("attendance") String attendance);
//-----------------------------------------------------------------

    @Modifying
    @Query("""
        DELETE FROM Student s
        WHERE s.id = :id
        """)
    int deleteStudentById(@Param("id") int id);

//-----------------------------------------------------------------
    @Query(value = """
                SELECT *
                FROM student
                WHERE age > :age
             """,
            nativeQuery = true)
    List<Student> findStudentsOlderThanNative(@Param("age")int age);


    @Modifying
    @Query(value =""" 
                    UPDATE student SET attendance = :attendance WHERE id = :id
                    """,
            nativeQuery = true
    )
    int updateAttendanceNative(
            @Param("attendance") String attendance,
            @Param("id") int id
    );
}
