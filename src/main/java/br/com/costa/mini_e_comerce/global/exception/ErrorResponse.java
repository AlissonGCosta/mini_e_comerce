package br.com.costa.mini_e_comerce.global.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
