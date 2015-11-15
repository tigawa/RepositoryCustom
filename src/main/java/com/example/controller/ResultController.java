package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.dto.ResultCriteria;
import com.example.model.Result;
import com.example.repository.ResultRepository;

@RestController
@RequestMapping("/result")
public class ResultController {
	
	@Autowired
	private ResultRepository resultRepository;

	// ページネーションはここを参照した。
	// "http://localhost:8080/result?staffId=1&page=0&size=2&sort=id"
	// https://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/Pagination.html#id11
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<Result> index(@RequestParam Integer staffId, Pageable pageable) {
		ResultCriteria criteria = new ResultCriteria();
		criteria.setStaffId(staffId);
//		BeanUtils.copyProperties(resultForm, criteria);
		return resultRepository.findByCriteria(criteria, pageable);
	}
}
