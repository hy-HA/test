package com.test.controller;

import com.test.dto.StudentRequest;
import com.test.dto.StudentResponse;
import com.test.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "student V1 API")
public class TestController {
    private final TestService testService;

    @ResponseBody
    @GetMapping("/student")
    @Operation(summary = "학생 정보를 모두 조회합니다.")
    public ResponseEntity<List<StudentResponse>> getStudentList() {
        List<StudentResponse> response = testService.getStudentList();

        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @GetMapping("/student/{id}")
    @Operation(summary = "학생 정보를 조회합니다.")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        StudentResponse response = testService.getStudent(id);

        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @PostMapping("/student")
    @Operation(
            summary = "학생 정보를 생성합니다.",
            description = "학생 정보를 생성할때에는 블라블라~~"
    )
    public ResponseEntity<StudentResponse> insertStudent(@RequestBody StudentRequest request) {
        StudentResponse response = testService.createStudent(request);

        return ResponseEntity.ok(response);
    }

    /*@ResponseBody
    @PostMapping("/student1")
    public ResponseEntity<StudentResponse> insertStudent1(StudentRequest request) {
        StudentResponse response = testService.createStudent(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/student2")
    public StudentResponse insertStudent2(@RequestBody StudentRequest request) {
        StudentResponse response = testService.createStudent(request);

        return response;
    }*/

}

