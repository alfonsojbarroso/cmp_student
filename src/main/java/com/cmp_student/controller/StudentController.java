package com.cmp_student.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmp_student.dto.StudentRequestDto;
import com.cmp_student.dto.StudentResponseDto;
import com.cmp_student.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${student.path}")
@CrossOrigin(origins = { "http://localhost:4200", "http://127.0.01:4200" })
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Mono<StudentResponseDto> create(@Validated @RequestBody StudentRequestDto studentDto) {
        return studentService.create(studentDto);
    }

    @GetMapping
    public Flux<StudentResponseDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-by-id")
    public Mono<StudentResponseDto> findById(@RequestParam("id") Integer id) {
        return studentService.findById(id);
    }

}
