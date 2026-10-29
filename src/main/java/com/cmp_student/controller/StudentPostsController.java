package com.cmp_student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmp_student.dto.StudentPostsResponseDto;
import com.cmp_student.service.StudentPostsService;

import reactor.core.publisher.Mono;

@RestController 
@RequestMapping("${student.posts.path}")
public class StudentPostsController {

    private final StudentPostsService studentPostsService;

    public StudentPostsController(StudentPostsService studentPostsService) {
        this.studentPostsService = studentPostsService;
    }

    @GetMapping ("/by-student-id")
    public Mono<StudentPostsResponseDto> findStudentPostsByStudentId(@RequestParam("studentId") Integer id) {
        return studentPostsService.getStudentPostsByUserId(id);
    }

}
