package co.istad.demo_relationship.controller;


import co.istad.demo_relationship.model.Student;
import co.istad.demo_relationship.model.request.StudentRequest;
import co.istad.demo_relationship.repository.StudentRepository;
import co.istad.demo_relationship.service.StudentService;
import co.istad.demo_relationship.service.serviceImpl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentControlller {
     private final StudentService studentService;
    private final StudentServiceImpl studentServiceImpl;
    @PostMapping("/add")
     public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
         Student student = studentService.createStudent(studentRequest);
         return ResponseEntity.ok(student);
     }

     @GetMapping
    public ResponseEntity<?> getAllStudent(){
         List<Student> student = studentServiceImpl.getAllStudent();
         return ResponseEntity.ok(student);
     }

     @GetMapping("{id}")
    public ResponseEntity<?> getStudentById (@PathVariable Integer id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
     }

     @PutMapping("{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentRequest studentRequest,
                                           @PathVariable Integer id){
        Student student = studentService.updateStuden(studentRequest, id);
        return ResponseEntity.ok(student);

     }

     @DeleteMapping("{id}")
     public ResponseEntity deleteStudent(Integer id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("delete successfully") ;
     }

     @GetMapping("/name/{name}")
    public ResponseEntity<?> findStudentByName(@RequestParam String name){
        List<Student> student = studentService.findByName(name);
        return ResponseEntity.ok(student);
     }
}
