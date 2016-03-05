package com.saran;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

import com.saran.service.LoginService;

public class MockTestContext {
	
	@Bean
    public LoginService loginService() {
        return Mockito.mock(LoginService.class);
    }

}
