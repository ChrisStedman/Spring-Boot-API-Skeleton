package com.example.skeleton.example.mapper;

import com.example.skeleton.api.model.Example;
import com.example.skeleton.example.domain.ExampleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExampleMapper {

    @Mapping(target = "exampleId", source = "id")
    ExampleDomain toExampleDomain(Example example);

    @Mapping(target = "id", source = "exampleId")
    Example toResponseExample(ExampleDomain example);

}
