package com.cmp_student.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.cmp_student.dto.ErrorMessageDto;
import com.cmp_student.dto.StudentRequestDto;
import com.cmp_student.dto.StudentResponseDto;
import com.cmp_student.exception.BusinessException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Value("${base.url.player}")
    private String baseUrlPlayer;
    private final WebClient webClient;

    public StudentService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<StudentResponseDto> create(StudentRequestDto studentDto) {
        return webClient.post()
                .uri(baseUrlPlayer)
                .bodyValue(studentDto)
                .retrieve()
                .bodyToMono(StudentResponseDto.class);
    }

    public Flux<StudentResponseDto> findAll() {
        return webClient.get()
                .uri(baseUrlPlayer)
                .retrieve()
                .bodyToFlux(StudentResponseDto.class);
    }

    public Mono<StudentResponseDto> findById(Integer id) {
        return webClient.get()
                .uri(baseUrlPlayer + "/find-by-id?id={id}", id)
                .exchangeToMono(
                        response -> {
                            if (response.statusCode().is2xxSuccessful()) {
                                return response.bodyToMono(StudentResponseDto.class);
                            } else {
                                return response.bodyToMono(ErrorMessageDto.class)
                                        .flatMap(errorBody -> Mono.error(new BusinessException(
                                                new ErrorMessageDto(errorBody.message(), errorBody.httpStatus(),
                                                        errorBody.timestamp()))));
                            }
                        }

                );
    }

}
