package com.authentication.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(int statusCode, String message) {
}