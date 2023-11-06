package com.pmm.core;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmm.core.Student;

import org.springframework.stereotype.Repository;
@Repository

public interface StudentRepository extends JpaRepository<Student, Serializable> {
}



