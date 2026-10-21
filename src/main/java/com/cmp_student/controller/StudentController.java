package com.cmp_student.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmp_student.dto.PostDto;
import com.cmp_student.dto.StudentDto;
import com.cmp_student.dto.StudentRsDto;
import com.cmp_student.service.PostService;
import com.cmp_student.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final PostService postService;

    public StudentController(StudentService studentService, PostService postService) {
        this.studentService = studentService;
        this.postService = postService;
    }

    @PostMapping
    public Mono<StudentRsDto> create(@Validated @RequestBody StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @GetMapping
    public Flux<StudentDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/posts")
    public Flux<PostDto> getPosts(@RequestParam("userId") Integer userId) {
        return postService.getPostByUserId(userId);
    }

}
