package com.example.skeleton.repository;

import com.example.skeleton.domain.ExampleDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<ExampleDomain, Long> {
}
