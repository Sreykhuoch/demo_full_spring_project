package co.istad.demo_relationship.repository;


import co.istad.demo_relationship.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository <StudentCourse, Integer>{

}
