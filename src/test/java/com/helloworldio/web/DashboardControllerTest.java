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

import com.helloworldio.web.fixture.DashboardController;


public class DashboardControllerTest {
	
	private static final String FORWARDED_URL 	= "/WEB-INF/view/jsp/dashboard.jsp";
	private static final String VIEW 			= "dashboard";
	
	
	MockMvc mockMvc;
	
	@InjectMocks
	DashboardController sut;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(sut)
									.setViewResolvers(viewResolver())
									.build();
	}
	
	private InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Test
	public void rootUrlForwardsCorrectlyWhenNavigateDashboard() throws Exception {
		// Act
		mockMvc.perform(get("/dashboard"))
				.andDo(print())
		
		// Assert
				.andExpect(status().isOk())
				.andExpect(view().name(VIEW))
				.andExpect(forwardedUrl(FORWARDED_URL));
	}
}
