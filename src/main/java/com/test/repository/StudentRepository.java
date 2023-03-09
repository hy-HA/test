package com.test.repository;

import com.test.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public void delete(Student student){
        em.remove(student);
    }

    public Student findOne(Long id) {
        return em.find(Student.class, id);
    }


}
