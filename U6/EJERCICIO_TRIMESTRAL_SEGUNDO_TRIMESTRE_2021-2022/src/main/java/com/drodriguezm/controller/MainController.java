package com.drodriguezm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drodriguezm.dto.AsignaturaProfesorDTO;
import com.drodriguezm.dto.ProfesorDTO;
import com.drodriguezm.model.Asignatura;
import com.drodriguezm.model.Departamento;
import com.drodriguezm.model.Profesor;
import com.drodriguezm.services.AsignaturaService;
import com.drodriguezm.services.DepartamentoService;
import com.drodriguezm.services.ProfesorService;


@Controller
public class MainController {
	@Autowired
	ProfesorService profesorSer;
	
	@Autowired
	AsignaturaService asignaturaSer;
	
	@Autowired
	DepartamentoService departamentoSer;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping("/profesores")
	public String profesores(Model model, @RequestParam(required=false,name="error") String error) {
		if (error != null) model.addAttribute("error", "PROFESOR NO SELECCIONADO");
		
		List<Profesor> profesores = profesorSer.getAllProfesor();
		model.addAttribute("profesores", profesores);
		return "profesoresList";
	}
	
	@GetMapping("/profesores/asignaturas")
	public String ProfesoresAsignaturasGet(Model model,@RequestParam(required=false,name="prof") String prof) {
		if (prof == null) 
			return "redirect:/profesores?error=true";
		
		Long id = Long.valueOf(prof);
		Profesor profesor = profesorSer.findProfesorById(id);
		model.addAttribute("profesor", profesor);
		
		return "profesorAsignaturas";
	}
	
	@GetMapping("/profesores/addAsignatura")
	public String AddAsignaturProfesoresGet(Model model,@RequestParam(required=false,name="error") String error) {
		AsignaturaProfesorDTO asignaturaProfesorDTO = new AsignaturaProfesorDTO();		
		model.addAttribute("asignaturaProfesorDTO", asignaturaProfesorDTO);
		
		List<Profesor> profesores = profesorSer.getAllProfesor();
		model.addAttribute("profesores", profesores);
		
		List<Asignatura> asignaturas = asignaturaSer.getAllAsignaturas();
		model.addAttribute("asignaturas", asignaturas);
		
		if (error != null) model.addAttribute("error", "LA ASIGNATURA TIENE UN PROFESOR YA ASIGNADO");
		
		return "addAsignaturaProfesor";
	}
	
	@PostMapping("/profesores/addAsignatura")
	public String AddAsignaturProfesoresPost(@ModelAttribute AsignaturaProfesorDTO asignaturaProfesoresDTO, Model model) {	
		Profesor profesor = profesorSer.findProfesorById(asignaturaProfesoresDTO.getProfesorId());
		Asignatura asignatura = asignaturaSer.findAsignaturaById(asignaturaProfesoresDTO.getAsignaturaId());
		
		if (asignatura.getProfesor() != null) return "redirect:/profesores/addAsignatura?error=true";
		
		profesor.addAsignatura(asignatura);
		
		if (profesorSer.actualizarProfesor(profesor) != null)
			return "redirect:/profesores/asignaturas?prof=" + profesor.getId();
		else
			return "redirect:/profesores/addAsignatura";
	}
	
	@GetMapping("/profesores/addProfesor")
	public String addProfesoresGet(Model model, @RequestParam(required=false,name="error") String error) {			
		ProfesorDTO profesorDTO = new ProfesorDTO();		
		model.addAttribute("profesorDTO", profesorDTO);
		
		List<Departamento> departamentos = departamentoSer.getAllDepartmentos();
		model.addAttribute("departamentos", departamentos);
		
		if (error != null) model.addAttribute("error","PROFESOR YA EXISTENTE");

		return "addProfesor";
	}
	
	@PostMapping("/profesores/addProfesor")
	public String addProfesoresPost(@ModelAttribute ProfesorDTO proDTO, Model model) {	
		Profesor profesor = new Profesor();
		profesor.setNif(proDTO.getNif());
		profesor.setNombre(proDTO.getNombre());
		profesor.setApellido1(proDTO.getApellido1());
		profesor.setApellido2(proDTO.getApellido2());
		profesor.setCiudad(proDTO.getCiudad());
		profesor.setDireccion(proDTO.getDireccion());
		profesor.setTelefono(proDTO.getTelefono());
		profesor.setFechaNacimiento(proDTO.getFechaNacimiento());
		profesor.setDepartamento(departamentoSer.findDepartamentoById(proDTO.getDepartamentoId()));
		
		if (profesorSer.insertarProfesor(profesor) == null) 
			return "redirect:/profesores/addProfesor";
		else 
			return "redirect:/profesores";
	}

}
