package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.CategoryDAO;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDAO, Integer>{

}
