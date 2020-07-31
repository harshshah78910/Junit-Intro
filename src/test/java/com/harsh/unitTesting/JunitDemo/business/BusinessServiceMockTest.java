package com.harsh.unitTesting.JunitDemo.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.harsh.unitTesting.JunitDemo.BusinessService;
import com.harsh.unitTesting.JunitDemo.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockTest {

	@InjectMocks
	BusinessService businessService;

	@Mock
	SomeDataService someDataServiceMock;
	//SomeDataService someDataServiceMock = Mockito.mock(SomeDataService.class);
	
//	@Before
//	public void setSomeDataService()
//	{
//		businessService.setSomeDataService(someDataServiceMock);
//	}

	@Test
	public void calculateUsingSomeDataService_basicTest() {

		Mockito.when(someDataServiceMock.retrieveSomeData(new int[] { 1, 2, 4 })).thenReturn(1);
	
		int actualSum = businessService.calculateUsingSomeDataService(new int[] { 1, 2, 4 });
		assertEquals(1, actualSum);
	}

	@Test
	public void calculateUsingSomeDataService_EmptyTest() {

		Mockito.when(someDataServiceMock.retrieveSomeData(new int[] { 1, 2, 4 })).thenReturn(0);

		int actualSum = businessService.calculateUsingSomeDataService(new int[] { 1, 2, 4 });
		assertEquals(0, actualSum);
	}
}
