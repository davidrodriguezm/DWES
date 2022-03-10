package com.drodriguezm.repository;

import com.drodriguezm.model.Departamento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long>{
	
	public Optional<Departamento> findByNombre(String nombre);
	public Optional<Departamento> findById(Long id);
}
