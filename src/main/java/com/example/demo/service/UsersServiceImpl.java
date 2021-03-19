package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;


@Transactional
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository repo;

	@Override
	public List<Users> findAll() {
		return repo.findAll();
		
	}

	public void save(Users user) {
		repo.save(user);
		
	}

}
