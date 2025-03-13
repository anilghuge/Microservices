package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface IProductDAO extends JpaRepository<Product,Integer> {

}
