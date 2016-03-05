package com.saran.service;

import java.util.List;

import com.saran.dto.LoginDto;

public interface LoginService {
	Long saveDetails(LoginDto login);
	List<LoginDto> fetchByName(String name);
	List<LoginDto> findAll();
	LoginDto fetchById(Long id);
}
