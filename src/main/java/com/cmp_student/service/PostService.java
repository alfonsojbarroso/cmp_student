package com.cmp_student.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cmp_student.dto.UserPostsResponseDto;

import reactor.core.publisher.Flux;

@Service
public class PostService {

    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<UserPostsResponseDto> findUserPosts(Integer userId) {
        return webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts?userId={userId}", userId)
                .retrieve()
                .bodyToFlux(UserPostsResponseDto.class);
    }

}
