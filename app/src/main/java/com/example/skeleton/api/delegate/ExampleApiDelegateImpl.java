package com.example.skeleton.api.delegate;

import com.example.skeleton.api.ExampleApiDelegate;
import com.example.skeleton.api.model.Example;
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
        List<Example> examples = exampleService.getExamples();

        return ResponseEntity.ok()
                .body(examples);
    }

    @Override
    public ResponseEntity<Example> createExample(Example example) {
        Example createdExample = exampleService.createExample(example);

        return ResponseEntity.ok()
                .body(createdExample);
    }

    @Override
    public ResponseEntity<Example> getExample(Long exampleId) {
        Example example = exampleService.getExample(exampleId);

        return ResponseEntity.ok()
                .body(example);
    }
}
