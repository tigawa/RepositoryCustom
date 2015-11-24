package com.example.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.RepositoryCustomApplication;
import com.example.model.Result;
import com.example.model.ResultDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RepositoryCustomApplication.class)
public class ResultRepositoryTest {
	
	@Autowired
	ResultRepository resultRepository;

	@Autowired
	ResultDetailRepository resultDetailRepository;

	@Test
	public void test() {
		{
			List<Result> list = resultRepository.findAll(new Sort("id"));
			for (Result result : list) {
				System.out.println(result);
			}
		}

		Result in = new Result();
		in.setId(1);
		
		ResultDetail detail = new ResultDetail();
		detail.setId(500);
		detail.setPoint(10000);
		detail.setResult(in);
		resultDetailRepository.save(detail);

		{
			List<Result> list = resultRepository.findAll(new Sort("id"));
			for (Result result : list) {
				System.out.println(result);
			}
		}
		
		{
			List<ResultDetail> list = resultDetailRepository.findAll(new Sort("id"));
			for (ResultDetail d : list) {
				System.out.println(d);
			}
		}
		
	}
	
	@Test
	public void copy(){
		
		Result source = new Result();
		source.setTypeCode(1000);
		Result target = new Result();
		BeanUtils.copyProperties(source, target);

		Assert.assertEquals(source, target);
		
	}
	
	@Test
	public void findByTypeCode(){
		Result result = resultRepository.findByTypeCode(100);
		Assert.assertEquals(1, result.getId());
	}
}
