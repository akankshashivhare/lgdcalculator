package com.ubs.credit.wmonline.lgdcalculator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ubs.credit.wmonline.lgdcalculator.service.LGDCalculatorCacheService;


@Component
public class CacheInit implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private LGDCalculatorCacheService lgdcalculatorservice;
	
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	lgdcalculatorservice.findAll();
    }

}
