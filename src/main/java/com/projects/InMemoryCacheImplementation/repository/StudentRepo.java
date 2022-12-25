package com.projects.InMemoryCacheImplementation.repository;

import com.projects.InMemoryCacheImplementation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
