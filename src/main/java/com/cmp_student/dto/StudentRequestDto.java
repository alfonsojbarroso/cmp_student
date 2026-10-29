package com.cmp_student.dto;

import com.cmp_student.constraints.SanitizedHtml;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import tools.jackson.databind.ObjectMapper;

import static com.cmp_student.constants.Constants.DANGERPUS_HTML_CODE;
import static com.cmp_student.constants.Constants.NAME_MUST_NOT_BE_EMPTY;

public record StudentRequestDto(
        @JsonIgnore Integer id,
        @NotBlank(message = NAME_MUST_NOT_BE_EMPTY) String name,
        @SanitizedHtml(message = DANGERPUS_HTML_CODE) String lastName,
        @SanitizedHtml(message = DANGERPUS_HTML_CODE) String phone,
        String eMail) {

    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }

}
