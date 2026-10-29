package com.cmp_student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cmp_student.dto.PostsResponseDto;
import com.cmp_student.dto.StudentPostsResponseDto;

import reactor.core.publisher.Mono;

@Service
public class StudentPostsService {

    private final StudentService studentService;
    private final PostsService postService;

    public StudentPostsService(StudentService studentService, PostsService postService) {
        this.studentService = studentService;
        this.postService = postService;
    }

    public Mono<StudentPostsResponseDto> getStudentPostsByUserId(Integer id) {
        return studentService.findById(id)
                .flatMap(
                        student -> {
                            Mono<List<PostsResponseDto>> monoPosts = postService.findUserPosts(student.id())
                                    .collectList();
                            return monoPosts.map(
                                    studentPosts -> new StudentPostsResponseDto(student, studentPosts));
                        });
    }

}
