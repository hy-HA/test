package com.test.repository;

import com.test.domain.Student;
import com.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long>  {
}
