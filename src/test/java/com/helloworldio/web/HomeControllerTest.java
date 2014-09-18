package com.helloworldio.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.helloworldio.web.fixture.HomeController;


public class HomeControllerTest {
	
	private static final String FORWARDED_URL 	= "/WEB-INF/view/home.jsp";
	private static final String VIEW 			= "/home";
	
	
	MockMvc mockMvc;
	
	@InjectMocks
	HomeController sut;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(sut)
									.setViewResolvers(viewResolver())
									.build();
	}
	
	private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Test
	public void rootUrlForwardsCorrectlyWhenNavigateRootPath() throws Exception {
		// Act
		mockMvc.perform(get("/"))
				.andDo(print())
		
		// Assert
				.andExpect(status().isOk())
				.andExpect(view().name(VIEW))
				.andExpect(forwardedUrl(FORWARDED_URL));
	}
	
	@Test
	public void rootUrlForwardsCorrectlyWhenNavigateHome() throws Exception {
		// Act
		mockMvc.perform(get("/home"))
				.andDo(print())
		
		// Assert
				.andExpect(status().isOk())
				.andExpect(view().name(VIEW))
				.andExpect(forwardedUrl(FORWARDED_URL));
	}
}
