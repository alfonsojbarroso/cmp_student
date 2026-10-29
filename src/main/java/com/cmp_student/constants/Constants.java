package com.cmp_student.constants;

public final class Constants {

    public static final String NAME_MUST_NOT_BE_EMPTY = "Name must not be empty";
    public static final String DANGERPUS_HTML_CODE = "Potentially dangerous HTML code was detected";
    public static final String UTILITY_CLASS = "This is a utility class and cannot be instantiated.";

    private Constants() {
        throw new UnsupportedOperationException(UTILITY_CLASS);
    }

}
