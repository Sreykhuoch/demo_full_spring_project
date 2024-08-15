package co.istad.demo_relationship.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseRequest {

    private Integer studentId;
    private Integer courseId;
    private Date enrollmentDate;
}
