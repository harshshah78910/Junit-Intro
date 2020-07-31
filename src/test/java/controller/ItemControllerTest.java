package controller;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.harsh.unitTesting.JunitDemo.business.ItemBusinessService;
import com.harsh.unitTesting.JunitDemo.controller.ItemController;
import com.harsh.unitTesting.JunitDemo.model.DataEntityExample;
import com.harsh.unitTesting.JunitDemo.model.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ItemController.class)
@ContextConfiguration(classes = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	

	@Test
	public void helloWorld_Basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Iphone\",\"price\":233,\"quantity\":1}")).andReturn();

		//assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void getFromItemBusinessService_Basic() throws Exception {
		
		Mockito.when(businessService.retrieveItem()).thenReturn(new Item(2, "Iphone", 233, 1));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/businessItem").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"id\":2,\"name\":\"Iphone\",\"price\":233,\"quantity\":1}")).andReturn();

		//assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	public void retrieveFromDataLayer_Basic() throws Exception {
		
		DataEntityExample dataEntityExample = new DataEntityExample();
		dataEntityExample.setId(1000);
		dataEntityExample.setName("iphone");
		dataEntityExample.setValue(0);
		Mockito.when(businessService.getAllItemsFromDB()).thenReturn(Arrays.asList(dataEntityExample));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/allItems").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[{\"id\":1000,\"name\":\"iphone\",\"value\":0}]")).andReturn();

		//assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}
	
	
}
