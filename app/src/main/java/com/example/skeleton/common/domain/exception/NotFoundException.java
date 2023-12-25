package com.example.skeleton.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    enum Type = {DATA, EXAMPLE};
    private final Long id;

}
