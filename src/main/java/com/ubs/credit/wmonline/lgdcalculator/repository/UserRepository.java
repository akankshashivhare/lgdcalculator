package com.ubs.credit.wmonline.lgdcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubs.credit.wmonline.lgdcalculator.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
