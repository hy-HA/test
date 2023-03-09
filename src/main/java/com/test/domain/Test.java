package com.test.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {

    @Id @GeneratedValue
    @Column(name="test_id")
    private Long id;

    private int score;


    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;

    //테스트결과
    public static Test createTest(Student student, Subject subject){
        Test test = new Test();
        test.setSubject(subject);
        test.setStudent(student);
        return test;
    }


}
