package com.example.skeleton.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Example")
@Table(name = "example_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDomain {

    @Id
    @SequenceGenerator(name = "example_sequence", sequenceName = "example_sequence", allocationSize = 1)
    @GeneratedValue(generator = "example_sequence")
    private Long id;
    private String name;
}
