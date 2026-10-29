package com.cmp_student.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import static com.cmp_student.constants.Constants.DANGERPUS_HTML_CODE;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SanitizedHtmlValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SanitizedHtml {
    String message() default DANGERPUS_HTML_CODE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class SanitizedHtmlValidator implements ConstraintValidator<SanitizedHtml, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String sanitizedValue = Jsoup.clean(value, Safelist.basic());

        return value.equals(sanitizedValue);
    }
}