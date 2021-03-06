package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
