package com.example.skeleton.mapper;

import com.example.skeleton.api.model.Example;
import com.example.skeleton.domain.ExampleDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExampleMapper {

    ExampleDomain toExampleDomain(Example example);

    Example toResponseExample(ExampleDomain example);

}
