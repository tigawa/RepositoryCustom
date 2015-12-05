package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.form.SimpleForm;
import com.example.model.Shop;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String hello(Model model) {
		SimpleForm simple = new SimpleForm();
		simple.setName("taiichi");
		
		Shop shop = new Shop();
		shop.setName("ローソン");
		simple.setShop(shop);
		
		model.addAttribute(simple);
	    return "hello";
	}
	
	@RequestMapping(value="edit", params = "goToTop")
	public String goToTop(@Validated @ModelAttribute SimpleForm simpleForm, BindingResult result, Model model){
	    if (result.hasErrors()) {
	        model.addAttribute("validationError", "不正な値が入力されました。");
	        return "hello";
	    }
	    System.out.println("name:" + simpleForm.getName());
	    System.out.println("Shop.name:" + simpleForm.getShop().getName());
	    
	    return "hello";
	}
}
