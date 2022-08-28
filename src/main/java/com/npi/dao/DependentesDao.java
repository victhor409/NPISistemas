package com.npi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npi.entities.Dependentes;

@Repository
public interface DependentesDao extends JpaRepository<Dependentes, Integer> {

	
}
