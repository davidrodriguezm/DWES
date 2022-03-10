package com.drodriguezm.repository;

import com.drodriguezm.model.Profesor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	public Optional<Profesor> findByNif(String nif);
	public Optional<Profesor> findById(Long id);
}
