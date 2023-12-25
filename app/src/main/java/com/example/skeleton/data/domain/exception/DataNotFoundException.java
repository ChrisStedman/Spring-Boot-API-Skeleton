package com.example.skeleton.data.domain.exception;

import com.example.skeleton.common.domain.exception.NotFoundException;

public class DataNotFoundException extends NotFoundException {

    public DataNotFoundException(Long dataId) {
        super(dataId, Type.DATA);
    }
}
