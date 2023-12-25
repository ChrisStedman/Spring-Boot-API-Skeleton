package com.example.skeleton.common.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    public enum Type { DATA, EXAMPLE };

    private final Long id;
    private final Type type;

}
