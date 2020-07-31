package com.harsh.unitTesting.JunitDemo;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import com.harsh.unitTesting.JunitDemo.data.SomeDataService;

@Component
public class BusinessService {

	private SomeDataService someDataService;
	
	public int calculateSum(int[] arry) {
		return Arrays.stream(arry).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateUsingSomeDataService(int[] arry)
	{
		return getSomeDataService().retrieveSomeData(arry);
	}

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	
}
