package com.cmp_student.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cmp_student.dto.PostsResponseDto;
import reactor.core.publisher.Flux;

@Service
public class PostsService {

    @Value("${posts.url}")
    private String postsUrl;
    private final WebClient webClient;

    public PostsService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<PostsResponseDto> findUserPosts(Integer userId) {
        return webClient.get()
                .uri(postsUrl + "/posts?userId={userId}", userId)
                .retrieve()
                .bodyToFlux(PostsResponseDto.class);
    }

}
