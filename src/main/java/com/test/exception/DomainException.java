package com.test.exception;

public class DomainException extends RuntimeException {

    private DomainException(String message) {
        super(message);
    }

    public static DomainException notFoundRow(Long id) {
        return new DomainException(String.format("%s 해당 Row가 존재하지 않습니다.", id));
    }
}
