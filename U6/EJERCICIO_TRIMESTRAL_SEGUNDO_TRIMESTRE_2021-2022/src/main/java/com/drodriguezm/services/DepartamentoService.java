package com.drodriguezm.services;

import java.util.ArrayList;
import java.util.List;

import com.drodriguezm.model.Departamento;
import com.drodriguezm.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepo;

	public List<Departamento> getAllDepartmentos() {		
		List<Departamento> deptsBD = departamentoRepo.findAll();		

		if (deptsBD != null && deptsBD.size() > 0) return deptsBD;
		
		return new ArrayList<Departamento>(); 		
	}
	
	public Departamento findDepartamentoById(Long id) {	
		return departamentoRepo.findById(id).get();
	}
	
	public Departamento getDepartamentByName(String nombre) {		
		if (nombre != null)
			return departamentoRepo.findByNombre(nombre).get();		
		else
			return null;
	}

	public Departamento insertarDepartamento(Departamento departamento) {		
		if (departamento != null && getDepartamentByName(departamento.getNombre()) == null) {
			Departamento dpto = departamentoRepo.save(departamento);
			return dpto;
			
		} else
			return null;
	}

	public Departamento actualizarDepartamento(Departamento departamento) {
		if (departamento == null || departamento.getId() == null || departamento.getNombre() == null)
			return null;
		else
			return departamentoRepo.save(departamento); 	
	}
	
}
