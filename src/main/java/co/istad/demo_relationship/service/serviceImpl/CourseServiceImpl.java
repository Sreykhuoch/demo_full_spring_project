package co.istad.demo_relationship.service.serviceImpl;


import co.istad.demo_relationship.exception.NotFoundException;
import co.istad.demo_relationship.model.Course;
import co.istad.demo_relationship.model.Student;
import co.istad.demo_relationship.model.request.CourseRequest;
import co.istad.demo_relationship.repository.CourseRepository;
import co.istad.demo_relationship.repository.StudentRepository;
import co.istad.demo_relationship.service.CourseService;
import co.istad.demo_relationship.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.getName());
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("course id is not found")
        );
        return course;
    }

    @Override
    public Course updateCourse(CourseRequest courseRequest, Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("id  is not found....")
        );
        course.setName(courseRequest.getName());
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new NotFoundException("id  is not found....")
        );
        courseRepository.delete(course);


    }
}
