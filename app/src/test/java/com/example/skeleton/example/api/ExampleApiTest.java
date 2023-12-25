package com.example.skeleton.example.api;

import com.example.skeleton.example.domain.ExampleDomain;
import com.example.skeleton.example.repository.ExampleRepository;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
public class ExampleApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ExampleRepository exampleRepository;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @DisplayName("GET Examples returns success")
    void getExamplesSuccess() {
        when(exampleRepository.findAll()).thenReturn(buildExampleList());

        RestAssuredMockMvc
                .when()
                    .get("/examples")
                .then()
                    .log().ifValidationFails()
                    .status(HttpStatus.OK)
                    .contentType(ContentType.JSON)
                    .body("", hasSize(2))
                    .body("[0].id", equalTo(1))
                    .body("[0].name", equalTo("Example"));
    }

    @Test
    @DisplayName("GET Example returns not found")
    void getExampleNotFound() {
        when(exampleRepository.findById(any())).thenReturn(Optional.empty());

        RestAssuredMockMvc
                .when()
                    .get("/examples/{exampleId}", 1)
                .then()
                    .log().ifValidationFails()
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(ContentType.JSON)
                    .body("code", equalTo("EX.404"))
                    .body("message", equalTo("EXAMPLE with id 1 not found"));
    }

    private List<ExampleDomain> buildExampleList(){
        return Arrays.asList(buildExampleDomain(), buildExampleDomain());
    }

    private ExampleDomain buildExampleDomain(){
        ExampleDomain example = new ExampleDomain();
        example.setExampleId(1L);
        example.setName("Example");

        return example;
    }

}
