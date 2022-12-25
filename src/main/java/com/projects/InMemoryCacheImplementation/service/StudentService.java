package com.projects.InMemoryCacheImplementation.service;

import com.projects.InMemoryCacheImplementation.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

}
