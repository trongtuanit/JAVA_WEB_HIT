package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer>{

}
