package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.controller.dto.ResultCriteria;
import com.example.model.Result;

public interface ResultRepositoryCustom {
	Page<Result> findByCriteria(ResultCriteria criteria, Pageable pageable);
}
