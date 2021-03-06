package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>, ResultRepositoryCustom {
	Result findByTypeCode(int typeCode);
}