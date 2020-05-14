package com.ubs.credit.wmonline.lgdcalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubs.credit.wmonline.lgdcalculator.entities.User;
import com.ubs.credit.wmonline.lgdcalculator.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

}
