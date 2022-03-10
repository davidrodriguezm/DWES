package com.drodriguezm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drodriguezm.model.Profesor;
import com.drodriguezm.model.Profesor;
import com.drodriguezm.repository.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	ProfesorRepository profesorRepo;
	
	public Profesor findProfesorById(Long id) {		
		return profesorRepo.findById(id).get();
	}
	
	public Profesor findProfesorByNif(String nif) {		
		return profesorRepo.findByNif(nif).get();
	}
	
	public List<Profesor> getAllProfesor() {		
		return profesorRepo.findAll(); 	
	}
	
	public Profesor insertarProfesor(Profesor profesor) {		
		if (profesor != null && findProfesorByNif(profesor.getNif()) == null) {
			Profesor profe = profesorRepo.save(profesor);
			return profe;
			
		} else
			return null;
	}

	public Profesor actualizarProfesor(Profesor profesor) {
		if (profesor == null || profesor.getId() == null || profesor.getNif() == null)
			return null;
		else
			return profesorRepo.save(profesor); 	
	}

}
