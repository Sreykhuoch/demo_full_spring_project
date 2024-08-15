package co.istad.demo_relationship.controller;


import co.istad.demo_relationship.model.Course;
import co.istad.demo_relationship.model.request.CourseRequest;
import co.istad.demo_relationship.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCourse(@RequestBody CourseRequest courseRequest){
        Course course = courseService.createCourse(courseRequest);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        List<Course> courseList = courseService.getAllCourse();
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        Course course = courseService.findCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("{id}")
     public ResponseEntity<?> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Integer id){
        Course course = courseService.updateCourse(courseRequest, id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourseById(id);
        return ResponseEntity.ok("delete successfully");

    }
}
