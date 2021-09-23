package com.gms.challengerFeira.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gms.challengerFeira.entity.Feira;


public interface FeiraRepository extends JpaRepository<Feira, Integer>{
	
	@Query(value = "select f from Feira f where (LOWER(f.distrito)=LOWER(:distrito) OR LOWER(f.regiao5)=LOWER(:regiao5) OR LOWER(f.nomeFeira)=LOWER(:nomeFeira) OR LOWER(f.bairro)=LOWER(:bairro))")
	List<Feira> findBySearchCriteria(@Param("distrito") String distrito, @Param("regiao5") String regiao5, @Param("nomeFeira") String nomeFeira, @Param("bairro") String bairro);
}
