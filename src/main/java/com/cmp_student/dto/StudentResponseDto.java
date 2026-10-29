package com.cmp_student.dto;

public record StudentResponseDto(
        Integer id,
        String name,
        String lastName,
        String phone,
        String eMail) {
}
