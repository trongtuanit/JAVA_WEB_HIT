package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.ProductDAO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDAO, Integer>{

}
