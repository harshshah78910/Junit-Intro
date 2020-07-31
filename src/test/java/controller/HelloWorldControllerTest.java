package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.harsh.unitTesting.JunitDemo.controller.HelloWorldController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(HelloWorldController.class)
@ContextConfiguration(classes = HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorld_Basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World")).andReturn();

		//assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}
	
	
}
