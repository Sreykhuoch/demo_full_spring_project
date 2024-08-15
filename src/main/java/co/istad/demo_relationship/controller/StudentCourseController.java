package co.istad.demo_relationship.controller;


import co.istad.demo_relationship.model.StudentCourse;
import co.istad.demo_relationship.model.request.StudentCourseRequest;
import co.istad.demo_relationship.service.StudentCourseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/StudentCourse")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    @PostMapping("/add")
    public ResponseEntity<?> createStudentCourse(@RequestBody StudentCourseRequest studentCourseRequest){
        StudentCourse studentCourse =  studentCourseService.createStudentCourse(studentCourseRequest);
        return ResponseEntity.ok(studentCourse);
    }

    @GetMapping
    public ResponseEntity<List<StudentCourse>> getAllStudentCourse(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam Sort.Direction orderBy
            ){
        List<StudentCourse> studentCourse = studentCourseService.getAllStudentCourse(page, size, sortBy, orderBy);
        return ResponseEntity.ok(studentCourse);
    }

    @GetMapping("{id}")
    public ResponseEntity<?>  getStudentCourseByid(@PathVariable  Integer id){
        StudentCourse studentCourse = studentCourseService.getStudentCourseId(id);
        return ResponseEntity.ok(studentCourse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudentCourse(@PathVariable Integer id){
        studentCourseService.deleteById(id);
        return ResponseEntity.ok("this id have  been deleted successfully!!");
    }

}
