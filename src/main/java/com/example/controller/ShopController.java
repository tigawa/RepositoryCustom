package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Shop;
import com.example.repository.ShopRepository;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopRepository shopRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Shop> index() {		
		return shopRepository.findAll();
	}
}
