package com.example.form;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.model.Shop;

public class SimpleForm implements Serializable {
	private static final long serialVersionUID = -157143280035400042L;
	
	@NotNull
	@Size(min = 1, max = 120)
	private String Name;
	
	@Valid
	private Shop shop;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
