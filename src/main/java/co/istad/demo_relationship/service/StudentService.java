package co.istad.demo_relationship.service;

import co.istad.demo_relationship.model.Student;
import co.istad.demo_relationship.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest studentRequest);

    List<Student> getAllStudent();

    Student findById(Integer id);

    Student updateStuden(StudentRequest studentRequest, Integer id);

    void deleteStudentById(Integer id);

        List<Student> findByName(String name);
}
