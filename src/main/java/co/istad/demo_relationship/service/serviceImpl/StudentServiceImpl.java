package co.istad.demo_relationship.service.serviceImpl;


import co.istad.demo_relationship.exception.NotFoundException;
import co.istad.demo_relationship.model.Card;
import co.istad.demo_relationship.model.Student;
import co.istad.demo_relationship.model.StudentCourse;
import co.istad.demo_relationship.model.request.StudentRequest;
import co.istad.demo_relationship.repository.CardRepository;
import co.istad.demo_relationship.repository.StudentRepository;
import co.istad.demo_relationship.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CardRepository cardRepository;
    @Override
    public Student createStudent(StudentRequest studentRequest){
        Card card = cardRepository.findById(studentRequest.getCardId()).orElseThrow(
                () -> new NotFoundException("id is not found")
        );

        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setCard(card);

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("is not found")
        );
        return student;
    }

    @Override
    public Student updateStuden(StudentRequest studentRequest, Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()  -> new NotFoundException("student id is not found")
        );

        Card card = cardRepository.findById(studentRequest.getCardId()).orElseThrow(
                ()-> new NotFoundException(" card id is not found")
        );
        student.setName(studentRequest.getName());
        student.setCard(card);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()  -> new NotFoundException("id is not found")
        );

         studentRepository.delete(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
