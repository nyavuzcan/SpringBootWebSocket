package com.example.springbootwebsocket.repository;

import com.example.springbootwebsocket.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  List<ProductEntity> findAllBy();
}
