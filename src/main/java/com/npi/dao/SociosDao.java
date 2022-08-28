package com.npi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npi.entities.Socios;

@Repository
public interface SociosDao extends JpaRepository<Socios, Integer> {

	
	
}
