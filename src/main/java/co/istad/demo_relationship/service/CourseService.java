package co.istad.demo_relationship.service;

import co.istad.demo_relationship.model.Course;
import co.istad.demo_relationship.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseRequest courseRequest);

    List<Course> getAllCourse();

    Course findCourseById(Integer id);

    Course updateCourse(CourseRequest courseRequest, Integer id);

    void deleteCourseById(Integer id);
}
