package com.example.skeleton.example.domain.exception;

import com.example.skeleton.common.domain.exception.NotFoundException;


public class ExampleNotFoundException extends NotFoundException {

    public ExampleNotFoundException(Long exampleId) {
        super(exampleId, Type.EXAMPLE);
    }
}
