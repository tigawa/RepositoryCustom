package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Shop;
@Repository
public interface StaffRepository extends JpaRepository<Shop, Integer> {

}
