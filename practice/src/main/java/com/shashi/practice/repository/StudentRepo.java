package com.shashi.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.shashi.practice.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
