package com.example.skeleton.service;

import com.example.skeleton.api.model.Example;
import com.example.skeleton.domain.ExampleDomain;
import com.example.skeleton.domain.exception.ExampleNotFoundException;
import com.example.skeleton.mapper.ExampleMapper;
import com.example.skeleton.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final ExampleMapper exampleMapper;

    public List<ExampleDomain> getExamples(){

        List<ExampleDomain> examples = exampleRepository.findAll();

        return examples;
    }

    public ExampleDomain createExample(Example example){
        ExampleDomain exampleDomain = exampleMapper.toExampleDomain(example);

        return exampleRepository.saveAndFlush(exampleDomain);
    }

    public ExampleDomain getExample(Long exampleId){
        Optional<ExampleDomain> example = exampleRepository.findById(exampleId);

        return example.orElseThrow(() -> new ExampleNotFoundException(exampleId));
    }
}
