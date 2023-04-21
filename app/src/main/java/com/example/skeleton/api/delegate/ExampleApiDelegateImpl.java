package com.example.skeleton.api.delegate;

import com.example.skeleton.api.ExampleApiDelegate;
import com.example.skeleton.api.model.Example;
import com.example.skeleton.domain.ExampleDomain;
import com.example.skeleton.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleApiDelegateImpl implements ExampleApiDelegate {

    private final ExampleService exampleService;

    @Override
    public ResponseEntity<List<Example>> getExamples(){
        List<ExampleDomain> examples = exampleService.getExamples();

        List<Example> mappedExamples =  examples.stream()
                .map(this::mapToExample)
                .toList();

        return ResponseEntity.ok()
                .body(mappedExamples);
    }

    @Override
    public ResponseEntity<Example> createExample(Example example) {
        ExampleDomain createdExample = exampleService.createExample(example);

        Example responseExample = mapToExample(createdExample);

        return ResponseEntity.ok()
                .body(responseExample);
    }

    @Override
    public ResponseEntity<Example> getExample(Long exampleId) {
        ExampleDomain example = exampleService.getExample(exampleId);

        Example responseExample = mapToExample(example);

        return ResponseEntity.ok()
                .body(responseExample);
    }

    private Example mapToExample(ExampleDomain exampleDomain){
        return new Example(exampleDomain.getId(), exampleDomain.getName());
    }
}
