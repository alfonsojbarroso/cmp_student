package com.cmp_student.dto;

import java.util.List;

public record StudentPostsResponseDto(
                StudentResponseDto responseDto,
                List<PostsResponseDto> postsResponseDtos) {
}
