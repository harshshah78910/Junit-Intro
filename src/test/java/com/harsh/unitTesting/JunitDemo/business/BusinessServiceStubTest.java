package com.harsh.unitTesting.JunitDemo.business;

import static org.junit.Assert.*;

import org.junit.Test;
import com.harsh.unitTesting.JunitDemo.BusinessService;
import com.harsh.unitTesting.JunitDemo.data.SomeDataService;

public class BusinessServiceStubTest {

	BusinessService businessService = new BusinessService();

	@Test
	public void calculateUsingSomeDataService_basicTest() {
		businessService.setSomeDataService(new SomeDataServiceStub());
		int actualSum = businessService.calculateUsingSomeDataService(new int[] { 1, 2, 4 });
		assertEquals(23, actualSum);
	}

}

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int retrieveSomeData(int[] arr) {

		return 23;
	}

}
