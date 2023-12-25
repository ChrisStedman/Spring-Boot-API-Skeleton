package com.example.skeleton.data.domain;

import com.example.skeleton.example.domain.ExampleDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity(name = "Data")
@Table(name = "data_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDomain {

    @Id
    @Column(name = "data_id")
    @SequenceGenerator(name = "data_sequence", sequenceName = "data_sequence", allocationSize = 1)
    @GeneratedValue(generator = "data_sequence")
    private Long dataId;
    private OffsetDateTime date;
    private String content;

    @ManyToOne
    @JoinColumn(name = "example_id", nullable = false)
    private ExampleDomain example;
}
