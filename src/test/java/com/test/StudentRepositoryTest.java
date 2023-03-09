package com.test;


import com.test.domain.Student;
import com.test.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @Transactional
    @DisplayName("학생등록")
    public void createStudent() throws Exception {
        //given
        Student student = new Student();
        student.setName("hee");

        //when
        studentRepository.save(student);
        long id = student.getId();

        //then
        Assertions.assertThat(id).isEqualTo(student.getId());
        Assertions.assertThat(student.getName()).isEqualTo("hee");
    }

    @Test
    @Transactional
    @DisplayName("학생업데이트")
    public void updateStudent() throws Exception {
        //given
        Student student = new Student();
        student.setName("hee");
        studentRepository.save(student);

        //when
        student.setName("hee2");
        studentRepository.save(student);
        long id = student.getId();

        //then
        Assertions.assertThat(id).isEqualTo(student.getId());
        Assertions.assertThat(student.getName()).isEqualTo("hee2");
    }

    @Test
    @Transactional
    @DisplayName("학생삭제")
    public void deleteStudent() throws Exception {
        //given
        Student student = new Student();
        student.setName("hee");

        //when
        studentRepository.save(student);
        long id = student.getId();
        studentRepository.delete(student);

        //then
        Assertions.assertThat(student.getName()).isEqualTo(null); //TODO null이 아닌 hee가 출력되고 있음
    }


}