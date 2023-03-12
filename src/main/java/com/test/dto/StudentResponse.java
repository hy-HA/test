package com.test.dto;

import com.test.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private Integer score;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.score = student.getScore();
    }
}
