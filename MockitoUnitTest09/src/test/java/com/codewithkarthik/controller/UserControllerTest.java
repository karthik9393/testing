package com.codewithkarthik.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.codewithkarthik.entity.User;
import com.codewithkarthik.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	UserService userService;

	@Autowired
	MockMvc mockMvc;

	public void test_saveUser() throws JsonProcessingException, Exception {
		User user = new User(100L, "Lipsa", "879456", "Hyderabad");
		when(userService.addUser(user)).thenReturn(user);
		mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user))).andExpect(status().isOk());
	}

}
