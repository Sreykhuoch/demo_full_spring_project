package co.istad.demo_relationship.repository;


import co.istad.demo_relationship.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //you can write your own query here like this :
    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByName(String name);


    //but also like this :
    //List<Student> findByName(String name);     : it is call method query where you have to
                                                 // define the method name as per the field name in the entity class
}
