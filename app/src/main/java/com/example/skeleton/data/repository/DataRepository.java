package com.example.skeleton.data.repository;

import com.example.skeleton.data.domain.DataDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataRepository extends JpaRepository<DataDomain, Long> {

    Optional<DataDomain> findByExample_ExampleIdAndDataId(Long exampleId, Long dataId);
}
