package com.saran.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saran.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>  {
	List<Login> findByName(String name);
	Login findById(Long id);
}
