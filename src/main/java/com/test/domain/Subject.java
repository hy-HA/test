package com.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//해당 클래스를 DB테이블과 매핑
@Entity @Getter @Setter
//엔티티와 매핑할 테이블을 지정
@Table(name="subject")
//파라미터가 없는 기본 생성자 생성
@NoArgsConstructor
public class Subject {

    //기본키를 DB가 생성해주는 값으로 사용
    @Id @GeneratedValue
    //객체 필드를 테이블 컬럼과 매핑(name: 필드외 매핑할 테이블 컬럼명 지정)
    @Column(name="subject_id")
    private Long id;

    private String subject;
    private int score;


    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<Test> tests = new HashSet<>();

    //연관관계 메서드
    public void addTest(Test test) {
        //test테이블의 subject에 있는 값을 test 맵으로 가져오기
        tests.add(test);
        //test리스트의 subject에 해당 subject 적용
        test.setSubject(this);
        this.setScore(test.getScore());
    }
}
