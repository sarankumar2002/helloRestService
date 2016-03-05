package com.saran.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class LoginDto implements Serializable {

	private static final long serialVersionUID = -351258469444374633L;
	private Long id;
	private String name;
	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
