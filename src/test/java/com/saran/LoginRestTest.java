package com.saran;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.saran.config.LoginConfig;
import com.saran.dto.LoginDto;
import com.saran.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={LoginConfig.class,MockTestContext.class})
@WebAppConfiguration
public class LoginRestTest {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	
	@Before
    public void setUp() {
		Mockito.reset(loginService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	
	@Test
	public void shouldSaveLoginDetails() throws Exception{
		
		LoginDto login = prepareLoginObject(6L, "Likhith", "Test11");
		
		//when
		org.mockito.Mockito.when(loginService.saveDetails(login)).thenReturn(6L);
		
		// Then
		   mockMvc.perform(post("/login/save")
				   .content(TestUtil.convertObjectToJsonBytes(login).getBytes())				   
				   .accept(MediaType.APPLICATION_JSON)
				   .contentType(TestUtil.APPLICATION_JSON_UTF8)
				   ).andExpect(status().isCreated());
	}
	
	private LoginDto prepareLoginObject(Long id, String name, String comments){
		LoginDto login = new LoginDto();
		login.setId(id);
		login.setComments(comments);
		login.setName(name);
		return login;
	}
	
	
}
