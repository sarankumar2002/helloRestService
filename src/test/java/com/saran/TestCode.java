package com.saran;

import java.io.IOException;

import org.junit.Test;

import com.saran.dto.LoginDto;

public class TestCode {
	
	@Test
	public void generateJson() throws IOException{
		LoginDto login = new LoginDto();
		login.setId(1L);
		login.setComments("test demo");
		login.setName("Saran");
		System.out.println(TestUtil.convertObjectToJsonBytes(login).toString());
	}

}
