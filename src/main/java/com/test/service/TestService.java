package com.test.service;


import com.test.domain.Student;
import com.test.domain.Subject;
import com.test.domain.Test;
import com.test.repository.StudentRepository;
import com.test.repository.SubjectRepository;
import com.test.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TestRepository testRepository;


    public Long createTest(Long studentId, Long subjectId) {

    //학생,과목 조회
    Student student = studentRepository.findOne(studentId);
    Subject subject = subjectRepository.findOne(subjectId);

    //테스트결과 조회
    Test test = Test.createTest(student, subject);

    //테스트결과 저장
    testRepository.save(test);
    return test.getId();

    }
}

