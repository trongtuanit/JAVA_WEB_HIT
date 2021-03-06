package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
