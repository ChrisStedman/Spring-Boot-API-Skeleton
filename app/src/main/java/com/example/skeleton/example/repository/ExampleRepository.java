package com.example.skeleton.example.repository;

import com.example.skeleton.example.domain.ExampleDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<ExampleDomain, Long> {
}
