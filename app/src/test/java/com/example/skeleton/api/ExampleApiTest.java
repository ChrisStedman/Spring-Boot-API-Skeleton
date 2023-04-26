package com.example.skeleton.api;

import com.example.skeleton.domain.ExampleDomain;
import com.example.skeleton.repository.ExampleRepository;
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
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

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
                .given()
                    .auth().with(httpBasicAuth())
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
                .given()
                    .auth().with(httpBasicAuth())
                .when()
                    .get("/examples/{exampleId}", 1)
                .then()
                    .log().ifValidationFails()
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(ContentType.JSON)
                    .body("code", equalTo("EX.404"))
                    .body("message", equalTo("Example with id 1 not found"));
    }

    @Test
    @DisplayName("GET Example without http basic returns unauthorised ")
    void getExampleUnauthorised() {
        RestAssuredMockMvc
                .when()
                    .get("/examples/{exampleId}", 1)
                .then()
                    .log().ifValidationFails()
                    .status(HttpStatus.UNAUTHORIZED);
    }

    private RequestPostProcessor httpBasicAuth(){
        return httpBasic("user", "password");
    }

    private List<ExampleDomain> buildExampleList(){
        return Arrays.asList(buildExampleDomain(), buildExampleDomain());
    }

    private ExampleDomain buildExampleDomain(){
        return new ExampleDomain(1L, "Example");
    }

}
