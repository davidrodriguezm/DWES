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

import com.drodriguezm.dto.AsignaturaGradoDTO;
import com.drodriguezm.dto.GradoDTO;
import com.drodriguezm.model.Asignatura;
import com.drodriguezm.model.Grado;
import com.drodriguezm.services.AsignaturaService;
import com.drodriguezm.services.GradoService;

@Controller
public class MainController {
	@Autowired
	GradoService gradoSer;
	
	@Autowired
	AsignaturaService asignaturaSer;
	
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping("/grados")
	public String grados(Model model) {
		List<Grado> grados = gradoSer.getAllGrado();
		model.addAttribute("grados", grados);
		return "gradosList";
	}
	
	@GetMapping("/grados/asignaturas")
	public String GradoAsignaturasGet(Model model,@RequestParam(required=false,name="codigo") String codigo) {
		Long id = Long.valueOf(codigo);
		Optional<Grado> grado = gradoSer.findGradoById(id);
		model.addAttribute("grado", grado.get());
		return "gradoAsignaturas";
	}
	
	@GetMapping("/grados/addGrado")
	public String addGradoGet(@RequestParam(required=false,name="error") String error, Model model) {			
		GradoDTO gradoDTO = new GradoDTO();		
		model.addAttribute("gradoDTO", gradoDTO);
		model.addAttribute("error", error);
		return "addGrado";
	}
	
	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO gradoDTO, Model model) {	
		Grado grado = new Grado(gradoDTO.getNombre());
		
		if (gradoSer.insertarGrado(grado)==null) 
			return "redirect:/grados/addGrado?error=Existe";
		else 
			return "redirect:/grados";
	}
	
	@GetMapping("/grados/addasignatura")
	public String AddAsignaturGradoGet(Model model) {
		AsignaturaGradoDTO asignaturaGradoDTO = new AsignaturaGradoDTO();		
		model.addAttribute("asignaturaGradoDTO", asignaturaGradoDTO);
		
		List<Grado> grados = gradoSer.getAllGrado();
		model.addAttribute("grados", grados);
		
		List<Asignatura> asignaturas = asignaturaSer.getAllAsignaturas();
		model.addAttribute("asignaturas", asignaturas);
		return "addAsignaturaGrado";
	}
	
	@PostMapping("/grados/addasignatura")
	public String AddAsignaturGradoPost(@ModelAttribute AsignaturaGradoDTO asignaturaGradoDTO, Model model) {	
		 
		return "redirect:/grados/asignaturas?codigo=1";
	}

}
