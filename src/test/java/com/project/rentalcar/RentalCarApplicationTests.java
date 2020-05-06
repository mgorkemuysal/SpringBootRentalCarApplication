package com.project.rentalcar;


import com.project.rentalcar.controller.CityController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Matcher;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RentalCarApplicationTests {
	/*
	@Test
	public void contextLoads() {
	}
	*/

	private MockMvc mockMvc;

	@InjectMocks
	private CityController cityController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(cityController)
				.build();
	}

	@Test
	public void findAllCitiesTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/city/1")
				.header("host","localhost:8080")
				.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.cityId", Matchers.is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.cityName", Matchers.is("Antalya")));


	}
}
