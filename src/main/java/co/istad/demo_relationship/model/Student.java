package co.istad.demo_relationship.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<StudentCourse> studentCourse;
}
