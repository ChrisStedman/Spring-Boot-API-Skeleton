package com.example.skeleton.data.mapper;

import com.example.skeleton.api.model.Data;
import com.example.skeleton.data.domain.DataDomain;
import com.example.skeleton.example.domain.ExampleDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DataMapper {

    @Mapping(target = "content", source = "data.content")
    @Mapping(target = "date", source = "data.created")
    DataDomain toDataDomain(Data data, ExampleDomain example);

    @Mapping(target = "id", source = "dataId")
    @Mapping(target = "created", source = "date")
    Data toResponseData(DataDomain data);
}
