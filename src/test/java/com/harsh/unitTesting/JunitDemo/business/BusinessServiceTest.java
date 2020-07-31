package com.harsh.unitTesting.JunitDemo.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.harsh.unitTesting.JunitDemo.BusinessService;


public class BusinessServiceTest {

	
	BusinessService businessService = new BusinessService();
	
	@Test
	public void calculateSum_basicTest() {
		int actualSum = businessService.calculateSum(new int[] {1,2,4});
		assertEquals(7, actualSum);
	}

}
