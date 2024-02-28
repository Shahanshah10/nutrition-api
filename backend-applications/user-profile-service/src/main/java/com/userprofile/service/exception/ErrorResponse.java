package com.userprofile.service.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
public record ErrorResponse(int statusCode, String message) {
}