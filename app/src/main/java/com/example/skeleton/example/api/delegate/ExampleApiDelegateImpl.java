package com.example.skeleton.example.api.delegate;

import com.example.skeleton.api.ExampleApiDelegate;
import com.example.skeleton.api.model.Example;
import com.example.skeleton.example.domain.ExampleDomain;
import com.example.skeleton.example.mapper.ExampleMapper;
import com.example.skeleton.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleApiDelegateImpl implements ExampleApiDelegate {

    private final ExampleService exampleService;
    private final ExampleMapper exampleMapper;

    @Override
    public ResponseEntity<List<Example>> getExamples(){
        List<ExampleDomain> examples = exampleService.getExamples();

        List<Example> mappedExamples =  examples.stream()
                .map(exampleMapper::toResponseExample)
                .toList();

        return ResponseEntity.ok()
                .body(mappedExamples);
    }

    @Override
    public ResponseEntity<Example> createExample(Example example) {
        ExampleDomain createdExample = exampleService.createExample(example);

        Example responseExample = exampleMapper.toResponseExample(createdExample);

        return ResponseEntity.ok()
                .body(responseExample);
    }

    @Override
    public ResponseEntity<Example> getExample(Long exampleId) {
        ExampleDomain example = exampleService.getExample(exampleId);

        Example responseExample = exampleMapper.toResponseExample(example);

        return ResponseEntity.ok()
                .body(responseExample);
    }

}
