package com.yt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yt.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
