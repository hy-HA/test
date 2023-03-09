package com.test.repository;

import com.test.domain.Student;
import com.test.domain.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepository {

    private final EntityManager em;

    public void save(Test test) {
        em.persist(test);
    }
    public List<Test> findAllTestByStudent(Student student){

    }
}
