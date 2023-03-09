package com.test.repository;

import com.test.domain.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class SubjectRepository {

    private final EntityManager em;

    public void save(Subject subject) {
        em.persist(subject);
    }

    public Subject findOne(Long id) {
        return em.find(Subject.class, id);
    }
}
