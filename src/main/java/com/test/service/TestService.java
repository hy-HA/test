package com.test.service;


import com.test.domain.Student;
import com.test.domain.Subject;
import com.test.domain.Test;
import com.test.dto.StudentRequest;
import com.test.dto.StudentResponse;
import com.test.exception.DomainException;
import com.test.repository.StudentRepository;
import com.test.repository.SubjectRepository;
import com.test.repository.TestRepository;
import com.test.repository.repositoryTest.StudentRepository2;
import com.test.repository.repositoryTest.SubjectRepository2;
import com.test.repository.repositoryTest.TestRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TestRepository testRepository;

    @Transactional
    public Long createTest(Long studentId, Long subjectId) {
        //학생,과목 조회
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> DomainException.notFoundRow(subjectId));
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> DomainException.notFoundRow(subjectId));

        //테스트결과 조회
        Test test = Test.of(student, subject);

        //테스트결과 저장
        testRepository.save(test);
        return test.getId();
    }

    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .score(request.getScore())
                .build();

        return new StudentResponse(studentRepository.save(student));
    }

    @Transactional(readOnly = true)
    public List<StudentResponse> getStudentList() {
        List<StudentResponse> result = new ArrayList<>();
        for (Student student : studentRepository.findAll()) {
            result.add(new StudentResponse(student));
        }

        return result;

        /*return studentRepository.findAll()
                .stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());*/
    }

    @Transactional(readOnly = true)
    public StudentResponse getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> DomainException.notFoundRow(id));

        return new StudentResponse(student);
    }
}

