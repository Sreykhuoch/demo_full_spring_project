package co.istad.demo_relationship.service.serviceImpl;

import co.istad.demo_relationship.exception.NotFoundException;
import co.istad.demo_relationship.model.Course;
import co.istad.demo_relationship.model.Student;
import co.istad.demo_relationship.model.StudentCourse;
import co.istad.demo_relationship.model.request.StudentCourseRequest;
import co.istad.demo_relationship.repository.CourseRepository;
import co.istad.demo_relationship.repository.StudentCourseRepository;
import co.istad.demo_relationship.repository.StudentRepository;
import co.istad.demo_relationship.service.StudentCourseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class StudentCourseServiceImpl implements StudentCourseService {
    private final StudentCourseRepository  studentCourseRepository;
     private  final StudentRepository studentRepository;
     private  final CourseRepository courseRepository;

    @Override
    public StudentCourse createStudentCourse(StudentCourseRequest studentCourseRequest) {
        Student student = studentRepository.findById(studentCourseRequest.getStudentId()).orElseThrow(
                () -> new NotFoundException("student id is not found")
        );

        Course course = courseRepository.findById(studentCourseRequest.getCourseId()).orElseThrow(
                () -> new NotFoundException("course id is not found")
        );

        StudentCourse studentCourse =  new StudentCourse();

        studentCourse.setStudent(student);
        studentCourse.setCourse(course);
        studentCourse.setEnrollmentDate(studentCourseRequest.getEnrollmentDate());
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllStudentCourse(int page, int size, String sortBy, Sort.Direction orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy, sortBy));
        Page<StudentCourse>  studentCourses = studentCourseRepository.findAll(pageable);
        return studentCourses.getContent();
    }

    @Override
    public StudentCourse getStudentCourseId(Integer id) {
        StudentCourse studentCourse = studentCourseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("student id is not found")
        );
        return studentCourse;
    }

    @Override
    public void deleteById(Integer id) {
        StudentCourse studentCourse = studentCourseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("student id is not found")
        );

        studentCourseRepository.delete(studentCourse);
    }


}
