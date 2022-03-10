package com.drodriguezm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.drodriguezm.model.Asignatura;
import com.drodriguezm.model.Departamento;
import com.drodriguezm.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

	@Autowired
	AsignaturaRepository asignaturaRepo;

	public List<Asignatura> getAllAsignaturas() {
		List<Asignatura> asignBD = asignaturaRepo.findAll();

		if (asignBD != null && asignBD.size() > 0) 
			return asignBD;
		else 
			return new ArrayList<Asignatura>();
	}
	
	public Asignatura findAsignaturaById(Long id) {			
		return asignaturaRepo.findById(id).get();
	}

}
