package com.cmp_student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmp_student.dto.UserPostsResponseDto;
import com.cmp_student.service.PostService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user-posts")
public class UserPostsController {

    private final PostService postService;

    public UserPostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Flux<UserPostsResponseDto> findUserPosts(@RequestParam("userId") Integer userId) {
        return postService.findUserPosts(userId);
    }

}
