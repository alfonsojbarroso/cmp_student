package com.cmp_student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cmp_student.dto.PostRsDto;
import com.cmp_student.dto.StudentRsDto;
import com.cmp_student.dto.UserPostRsDto;
import com.cmp_student.dto.UserPostsResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserPostService {

    private final StudentService studentService;
    private final PostService postService;

    public UserPostService(StudentService studentService, PostService postService) {
        this.studentService = studentService;
        this.postService = postService;
    }

    public Flux<UserPostRsDto> getUserPosts() {

        return studentService.findAll()
                .flatMap(

                        students -> {

                            Mono<List<UserPostsResponseDto>> mono = postService.findUserPosts(students.id())
                                    .collectList();
                            return mono.map(userPosts -> new UserPostRsDto(students, userPosts));
                        }

                );

    }

}
