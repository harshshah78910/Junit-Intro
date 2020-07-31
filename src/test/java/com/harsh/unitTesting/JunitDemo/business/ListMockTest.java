package com.harsh.unitTesting.JunitDemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {

	@Test
	public void sizeTest_Basic()
	{
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(5);
		
		assertEquals(5, listMock.size());
	}
	
	@Test
	public void sizeTest_MultipleInputs()
	{
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5, listMock.size());
		assertEquals(10, listMock.size());
	}
	
	@Test
	public void returnWithParameters()
	{
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.get(0)).thenReturn(5);
		
		assertEquals(5, listMock.get(0));
		
	}
	
	@Test
	public void returnWithParameters_Multiple()
	{
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.get(Mockito.anyInt())).thenReturn(5); //for any integer It will return 5
		
		assertEquals(5, listMock.get(3));
		
	}
	
	@Test
	public void verificationBasics()
	{
		List mock = Mockito.mock(List.class);
		Mockito.when(mock.get(0)).thenReturn(1);
		mock.get(0); //Calling it 1 time to pass below Verification
		Mockito.verify(mock).get(0);
//		Mockito.verify(mock,Mockito.times(1)).get(0);
//		Mockito.verify(mock,Mockito.atLeast(1)).get(0);
	}
	
	@Test
	public void argumentCapturing()
	{
		List mock = Mockito.mock(List.class);
		mock.add("Somethifn");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mock).add(captor.capture());
		
		assertEquals("Somethifn", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing()
	{
		List mock = Mockito.mock(List.class);
		mock.add("Somethifn1");
		mock.add("Somethifn2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(mock, Mockito.times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("Somethifn1", allValues.get(0));
		assertEquals("Somethifn2", allValues.get(1));
	}
	
	@Test
	public void mockingVsSpyig()
	{
		ArrayList mockArrayList = Mockito.mock(ArrayList.class);
		mockArrayList.add(12);
		System.out.println(mockArrayList.get(0));
		System.out.println(mockArrayList.size());
		Mockito.when(mockArrayList.size()).thenReturn(34);
		System.out.println(mockArrayList.size());
		
		ArrayList spyArrayList = Mockito.spy(ArrayList.class);
		spyArrayList.add(12);
		System.out.println(spyArrayList.get(0));
		System.out.println(spyArrayList.size());
		Mockito.when(spyArrayList.size()).thenReturn(34);
		System.out.println(spyArrayList.size());
		
	}
}
