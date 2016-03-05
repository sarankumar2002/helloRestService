package com.saran.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.saran.dto.LoginDto;
import com.saran.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value ="/save", produces ={MediaType.APPLICATION_JSON_VALUE},
	method =RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody Long saveDetails(@RequestBody LoginDto login ){
		return loginService.saveDetails(login);
	}
	
	@RequestMapping(value ="/findByName",method =RequestMethod.GET)
	public @ResponseBody List<LoginDto> findByName(@RequestParam("name") String name ){
		return loginService.fetchByName(name);
	}
	
	@RequestMapping(value ="/findById",method=RequestMethod.GET)
	public @ResponseBody LoginDto getMember(@RequestParam("id") Long id){
		return loginService.fetchById(id);
	}
	
	@RequestMapping(value ="/findAll",method=RequestMethod.GET)
	public @ResponseBody List<LoginDto> fetchAll(){
		return loginService.findAll();
	}
}
