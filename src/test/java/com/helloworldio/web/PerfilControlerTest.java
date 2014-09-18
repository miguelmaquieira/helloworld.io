package com.helloworldio.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.helloworldio.front.web.ProfileController;
import com.helloworldio.web.fixture.HomeController;

public class PerfilControlerTest {
	
	MockMvc mockMvc;
	
	@InjectMocks
	ProfileController sut;
	
	@Before
	public void setU() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
	}
	
	@Test
	public void timezoneHandlerGetRequest() throws Exception {
		// Act
//		mockMvc.perform(post("/profile/data/timezone")
//							.header("Accept=application/json")
//							.contentType(MediaType.APPLICATION_JSON))
//							.andDo(print())
//					
//			// Assert
//							.andExpect(status().isOk());	
	}
}
