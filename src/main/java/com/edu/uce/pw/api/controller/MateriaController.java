package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(path =  "/materias")
@RestController
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@PostMapping(path ="/guardar")
	public  void guardar (@RequestBody Materia materia) {
		materiaService.guardar(materia);
	};
	
	
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Materia materia) {
		
		materiaService.actualizar(materia);
		
	};
	
	
	@PatchMapping(path = "/actualizar/parcial")
	public void actualizarParcial(@RequestBody Materia materia) {
		Materia mater= this.materiaService.buscar(materia.getId());
		
		if(mater.getNombre()==null) {
			mater.setNombre(materia.getNombre());
		}else if(mater.getCodigo()==null) {
			mater.setNumeroCreditos(materia.getNumeroCreditos());
		}
		
		materiaService.actualizar(mater);
	}
	
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		materiaService.borrar(id);
		
	};
	
	@GetMapping(path =  "/buscar/{id}")
	public Materia buscar(@PathVariable Integer id) {
		
		return materiaService.buscar(id);
	};
	
	
	@GetMapping(path = "/buscar/creditos" )
	public List<Materia> burcarPorCreditos(@RequestParam String creditos) {
		
		
		return materiaService.buscarPorCreditos(creditos);
	}
	

}
