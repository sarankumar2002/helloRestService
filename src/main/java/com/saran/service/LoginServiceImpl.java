package com.saran.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saran.dao.repository.LoginRepository;
import com.saran.dto.LoginDto;
import com.saran.model.Login;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public Long saveDetails(LoginDto loginDto) {
		Login login = new Login();
		BeanUtils.copyProperties(loginDto, login);
		login.setCreatedDate(new Date());
		loginRepository.save(login);
		return login.getId();
	}

	@Override
	public List<LoginDto> fetchByName(String name) {
		List<LoginDto> loginDtoList = new ArrayList<LoginDto>();
		List<Login> loginList = loginRepository.findByName(name);

		for (Login login : loginList) {
			LoginDto dto = new LoginDto();
			BeanUtils.copyProperties(login, dto);
			loginDtoList.add(dto);
		}
		System.out.println("loginList=" + loginList);
		return loginDtoList;
	}

	@Override
	public List<LoginDto> findAll() {
		List<LoginDto> loginDtoList = new ArrayList<LoginDto>();
		List<Login> list = loginRepository.findAll();
		System.out.println(list.size());
		for (Login dbLogin : list) {
			LoginDto dto = new LoginDto();
			BeanUtils.copyProperties(dbLogin, dto);
			loginDtoList.add(dto);
		}
		return loginDtoList;
	}

	@Override
	public LoginDto fetchById(Long id) {
		Login login = loginRepository.findById(id);
		LoginDto dto = new LoginDto();
		//convert Entity to Dto
		BeanUtils.copyProperties(login, dto);		
		return dto;
	}

}
