package com.ubs.credit.wmonline.lgdcalculator.service;

import java.util.List;
import java.util.Optional;

import com.ubs.credit.wmonline.lgdcalculator.entities.User;


public interface UserService {
	
	List<User> findAll();
	
	Optional<User> findById(long id);

}
