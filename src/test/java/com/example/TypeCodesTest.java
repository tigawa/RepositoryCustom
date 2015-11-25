package com.example;

import org.junit.Assert;
import org.junit.Test;

public class TypeCodesTest {

	@Test
	public void test() {
		Assert.assertEquals("停止", TypeCodes.valueOf("停止").toString());
		Assert.assertEquals(1, TypeCodes.valueOf("停止").getCode());
		Assert.assertEquals("停止", TypeCodes.valueOf(1).toString());
		
		
		TypeCodes[] values = TypeCodes.values();
		for(TypeCodes t : values){
			System.out.println(t.getCode() + ":" + t.toString());
		}
	}
}
