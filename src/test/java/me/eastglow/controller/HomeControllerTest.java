package me.eastglow.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import me.eastglow.dao.TrafficDao;
import me.eastglow.service.impl.LoginServiceImpl;
import me.eastglow.service.impl.SearchServiceImpl;

@WebMvcTest
public class HomeControllerTest {
	
    @Autowired
    private MockMvc mvc;
    
    @MockBean 
    private TrafficDao dao;
    @MockBean
    private LoginServiceImpl loginService;
    @MockBean
    private SearchServiceImpl searchService;
    
	@Test
	public void goHomeTest() throws Exception {
		 mvc.perform(get("/"))
		 .andDo(print())
         .andExpect(status().isOk())
		 .andExpect(view().name("home"));
	}
	@Test
	public void goUserTest() throws Exception {
		 mvc.perform(get("/user"))
		 .andDo(print())
         .andExpect(status().isOk())
		 .andExpect(view().name("user"));
	}
	@Test
	public void goSearchTest() throws Exception {
		 mvc.perform(get("/search"))
		 .andDo(print())
         .andExpect(status().isOk())
		 .andExpect(view().name("search"));
	}
	@Test
	public void goPersonTest() throws Exception {
		 mvc.perform(get("/person"))
		 .andDo(print())
         .andExpect(status().isOk())
		 .andExpect(view().name("person"));
	}	
}
