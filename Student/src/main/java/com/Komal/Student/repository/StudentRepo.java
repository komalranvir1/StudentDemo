package com.Komal.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Komal.Student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

}
