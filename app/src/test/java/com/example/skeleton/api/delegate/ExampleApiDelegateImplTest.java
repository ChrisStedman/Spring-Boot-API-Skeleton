package com.example.skeleton.api.delegate;

import com.example.skeleton.api.model.Example;
import com.example.skeleton.domain.ExampleDomain;
import com.example.skeleton.mapper.ExampleMapper;
import com.example.skeleton.service.ExampleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExampleApiDelegateImplTest {

    @InjectMocks
    private ExampleApiDelegateImpl exampleApiDelegate;

    @Mock
    private ExampleService exampleService;

    @Mock
    private ExampleMapper exampleMapper;

    @Test
    @DisplayName("GET examples invokes service, maps response and returns success")
    void getExamples() {
        when(exampleService.getExamples()).thenReturn(buildExampleDomainList());
        when(exampleMapper.toResponseExample(any())).thenReturn(buildExample());

        ResponseEntity<List<Example>> result = exampleApiDelegate.getExamples();

        verify(exampleService).getExamples();
        verify(exampleMapper, times(2)).toResponseExample(any());

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(HttpStatus.OK, result.getStatusCode()),
                () -> assertNotNull(result.getBody()),
                () -> assertEquals(2, result.getBody().size())
        );
    }

    private List<ExampleDomain> buildExampleDomainList(){
        return Arrays.asList(buildExampleDomain(), buildExampleDomain());
    }

    private ExampleDomain buildExampleDomain(){
        return new ExampleDomain(1L, "Example");
    }

    private Example buildExample(){
        return new Example(1L, "Example");
    }
}