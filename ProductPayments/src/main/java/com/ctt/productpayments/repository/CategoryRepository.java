package com.ctt.productpayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctt.productpayments.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
