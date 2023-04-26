package com.example.skeleton.example.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExampleNotFoundException extends RuntimeException{
    private final Long exampleId;
}
