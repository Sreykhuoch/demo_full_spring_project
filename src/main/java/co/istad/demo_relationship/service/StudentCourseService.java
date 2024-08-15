package co.istad.demo_relationship.service;

import co.istad.demo_relationship.model.StudentCourse;
import co.istad.demo_relationship.model.request.StudentCourseRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentCourseService {
    StudentCourse createStudentCourse(StudentCourseRequest studentCourseRequest);

    List<StudentCourse> getAllStudentCourse(int page, int size, String sortBy, Sort.Direction orderBy);

    StudentCourse getStudentCourseId(Integer id);

    void deleteById(Integer id);
}
