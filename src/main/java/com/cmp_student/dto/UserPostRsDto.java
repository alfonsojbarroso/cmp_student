package com.cmp_student.dto;

import java.util.List;

public record UserPostRsDto(StudentRsDto studentRsDto, List<UserPostsResponseDto> userPostsResponseDto) {
}
