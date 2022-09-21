package com.test.demo.repository;

import com.test.demo.model.TestFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestFileRepository extends JpaRepository<TestFile, UUID> {
}
