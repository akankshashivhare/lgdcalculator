package com.ubs.credit.wmonline.lgdcalculator.service;

import java.util.List;
import java.util.Optional;

import com.ubs.credit.wmonline.lgdcalculator.entities.LGDCalculator;

public interface LGDCalculatorCacheService {

    List<LGDCalculator> findAll();
	
	Optional<LGDCalculator> findById(long id);
}
