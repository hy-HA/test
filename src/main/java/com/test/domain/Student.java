package com.test.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

//해당 클래스를 DB테이블과 매핑
@Entity @Getter @Setter
//엔티티와 매핑할 테이블을 지정
@Table(name="student")
//파라미터가 없는 기본 생성자 생성
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue
    //객체 필드를 테이블 컬럼과 매핑(name: 필드외 매핑할 테이블 컬럼명 지정)
    @Column(name = "student_id")
    private Long id;
    private String name;

    private int score;

    //test 테이블에 있는 student필드에 의해 매핑됨.(변경x, 읽기전용)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<>();

    @Builder
    public Student(String name){
        this.name = name;
    }

    //연관관계 메서드
    public void addTest(Test test) {
        //test테이블의 student에 있는 값을 test리스트로 가져오기
        tests.add(test);
        //test리스트의 student에 해당 student 적용
        test.setStudent(this);
        //test리스트의 score에 해당 score 적용
        this.setScore(test.getScore());
    }

    //특정 학생의 평균 점수 조회
    public void searchStudentScore(Long id) {


    }

}
