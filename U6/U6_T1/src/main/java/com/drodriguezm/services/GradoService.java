package com.drodriguezm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drodriguezm.model.Grado;
import com.drodriguezm.repository.GradoRepository;

@Service
public class GradoService {
	
	@Autowired
	GradoRepository gradoRepo;
	
	public Optional<Grado> findGradoById(Long id) {		
		return gradoRepo.findById(id);
	}
	
	public List<Grado> getAllGrado() {		
		return gradoRepo.findAll(); 	
	}
	
	public Grado getGradoByName(String nombre) {		
		if (nombre != null) {
			Grado grado = gradoRepo.findByNombre(nombre);
			return grado;		
		} else
			return null;
	}
		
	public Grado insertarGrado(Grado grado) {		
		if (grado != null && getGradoByName(grado.getNombre()) == null) {
			Grado gradonew = gradoRepo.save(grado);
			return gradonew;		
		} else
			return null;
	}

}
