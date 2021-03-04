package com.prueba.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.prueba.backend.entity.Socios;

@Repository
public interface SociosDao extends JpaRepository<Socios, Integer>{
	
	@Query(		
			value = "SELECT * FROM socios WHERE monto_maximo >= ?1 AND (SELECT MIN(tasa) FROM socios) ORDER BY tasa LIMIT 1",			
			nativeQuery = true
	)
	Socios searchSocio(Integer monto);
}