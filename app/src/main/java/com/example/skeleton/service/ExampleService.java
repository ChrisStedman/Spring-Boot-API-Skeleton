package com.example.skeleton.service;

import com.example.skeleton.api.model.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    public List<Example> getExamples(){
        return List.of(new Example(1L, "Stubbed example"));
    }

    public Example createExample(Example example){
        return new Example(1L, example.getName());
    }

    public Example getExample(Long exampleId){
        return new Example(exampleId, "Stubbed example");
    }
}
