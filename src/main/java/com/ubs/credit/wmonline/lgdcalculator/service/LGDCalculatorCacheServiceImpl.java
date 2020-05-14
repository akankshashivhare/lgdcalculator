package com.ubs.credit.wmonline.lgdcalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubs.credit.wmonline.lgdcalculator.entities.LGDCalculator;
import com.ubs.credit.wmonline.lgdcalculator.repository.LGDCalculatorRepository;

@Service
@Transactional
public class LGDCalculatorCacheServiceImpl implements LGDCalculatorCacheService  {

	
	@Autowired
	private LGDCalculatorRepository lgdCalculatorRepository;

	
	@Override
	@Cacheable("lgdcalculator")
	public List<LGDCalculator> findAll() {
		System.out.println("called once");
		List<LGDCalculator> calculatorlist= lgdCalculatorRepository.findAll();
		for(LGDCalculator calculator:calculatorlist)
		{
			System.out.println(calculator.getFirstName());
		}
		return calculatorlist;
	}

	@Override
	public Optional<LGDCalculator> findById(long id) {
		return lgdCalculatorRepository.findById(id);
	}
}
