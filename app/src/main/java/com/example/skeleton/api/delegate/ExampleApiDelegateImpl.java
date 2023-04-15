package com.example.skeleton.api.delegate;

import com.example.skeleton.api.ExampleApiDelegate;
import com.example.skeleton.api.model.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleApiDelegateImpl implements ExampleApiDelegate {

    @Override
    public ResponseEntity<List<Example>> getExamples(){
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Example> createExample(Example example) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Example> getExample(Long exampleId) {
        return ResponseEntity.ok().build();
    }
}
