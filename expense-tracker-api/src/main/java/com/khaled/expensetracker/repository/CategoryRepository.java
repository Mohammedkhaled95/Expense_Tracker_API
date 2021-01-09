package com.khaled.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khaled.expensetracker.model.Category;
@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer>{

	
}
