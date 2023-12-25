package com.example.skeleton.data.service;

import com.example.skeleton.api.model.Data;
import com.example.skeleton.data.domain.DataDomain;
import com.example.skeleton.data.domain.exception.DataNotFoundException;
import com.example.skeleton.data.mapper.DataMapper;
import com.example.skeleton.data.repository.DataRepository;
import com.example.skeleton.example.domain.ExampleDomain;
import com.example.skeleton.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataService {

    private final ExampleService exampleService;
    private final DataRepository dataRepository;
    private final DataMapper dataMapper;

    public Data getData(Long exampleId, Long dataId){
        Optional<DataDomain> dataList = dataRepository.findByExample_ExampleIdAndDataId(exampleId, dataId);

        return dataList.stream()
                .map(dataMapper::toResponseData)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException(dataId));
    }

    public DataDomain createData(Long exampleId, Data data){

        ExampleDomain example = exampleService.getExample(exampleId);

        DataDomain dataDomain = dataMapper.toDataDomain(data, example);

        return dataRepository.saveAndFlush(dataDomain);
    }
}
