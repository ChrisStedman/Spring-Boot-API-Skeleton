package com.example.skeleton.example.domain;

import com.example.skeleton.data.domain.DataDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Example")
@Table(name = "example_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDomain {

    @Id
    @Column(name = "example_id")
    @SequenceGenerator(name = "example_sequence", sequenceName = "example_sequence", allocationSize = 1)
    @GeneratedValue(generator = "example_sequence")
    private Long exampleId;
    private String name;
    @OneToMany(mappedBy = "example")
    private List<DataDomain> dataList;
}
