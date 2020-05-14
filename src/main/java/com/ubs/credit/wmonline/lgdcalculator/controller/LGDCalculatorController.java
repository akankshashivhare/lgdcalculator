package com.ubs.credit.wmonline.lgdcalculator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.credit.wmonline.lgdcalculator.entities.LGDCalculator;
import com.ubs.credit.wmonline.lgdcalculator.entities.User;
import com.ubs.credit.wmonline.lgdcalculator.exception.UserNotFoundException;
import com.ubs.credit.wmonline.lgdcalculator.model.ApiSuccess;
import com.ubs.credit.wmonline.lgdcalculator.service.LGDCalculatorCacheService;
import com.ubs.credit.wmonline.lgdcalculator.service.UserService;



@RestController
@RequestMapping("/lgdcalculator")
public class LGDCalculatorController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LGDCalculatorCacheService lgdCalculatorservice;
	
	@GetMapping
	public List<User>findAll(){
		
		return userService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id")long id){
		Optional<User>isUser=userService.findById(id);
		List<LGDCalculator> calculatorlist=lgdCalculatorservice.findAll();
		for(LGDCalculator calculator:calculatorlist)
		{
			System.out.println(calculator.getFirstName());
		}
		if(!isUser.isPresent()) {
			throw new UserNotFoundException("User is not found by given id "+id);
		}
		
		ApiSuccess<User> apiSuccess=new ApiSuccess<>();
		apiSuccess.setStatus(HttpStatus.OK);
		apiSuccess.setMessage("User details found");
		apiSuccess.setData(isUser.get());
		return new ResponseEntity<>(apiSuccess, new HttpHeaders(), apiSuccess.getStatus());
	}

}
