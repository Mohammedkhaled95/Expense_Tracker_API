package com.khaled.expensetracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.khaled.expensetracker.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}