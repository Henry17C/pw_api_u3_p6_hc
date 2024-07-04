package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;

import jakarta.annotation.security.PermitAll;
import jakarta.persistence.TypedQuery;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path= "/estudiantes")
public class EstudianteController {
	
	
	//INTERACCION DIRECTA CON EL SERVICE
	@Autowired
	private IEstudianteService estudianteService;
	
	
	//@RequestBoby: cuando se necesita enviar objetos entrada, se lo pone como argumaneto del metodo 
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante est) {
		/*
		Estudiante est= new Estudiante();
		est.setNombre("Henry");
		est.setApellido("Coyago");
		est.setFechaNacimiento(LocalDateTime.of(1999, 7,7,10,45,1));
		*/
		this.estudianteService.guardar(est);
		
		
		
	};
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar(@RequestBody Estudiante est) {
		
		//Estudiante est= this.estudianteService.buscar(1);
		//est.setNombre("Israel");
		//est.setApellido("Reinoso");
		this.estudianteService.actualizar(est);
	};
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	@PatchMapping(path = "/actualizar/parcial")
	public void actualizarParcial(@RequestBody Estudiante est) {
		Estudiante est2= this.estudianteService.buscar(est.getId());
		
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
		}
		
		if(est.getFechaNacimiento()!=null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}
		
		
		this.estudianteService.actualizar(est2);
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		
		this.estudianteService.borrar(id);
		
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1
	@GetMapping(path = "/buscar/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		
	return	this.estudianteService.buscar(id);
	};
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/2/nuevo/hola

	@GetMapping(path = "/buscar/{id}/nuevo/{dato}")
	public Estudiante buscar2(@PathVariable Integer id, @PathVariable String dato) {
		System.out.println("dato: "+ dato);
	return	this.estudianteService.buscar(id);
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M
	@GetMapping(path = "/buscarPorGenero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero){
		
		
		List<Estudiante> lista= this.estudianteService.buscarPorGenero(genero);
		return lista;
	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M&5
	@GetMapping(path = "/buscarPorGenero/nuevo")
	public List<Estudiante> buscarPorGenero2(@RequestParam String genero, @RequestParam Integer edad){
		
		System.out.println("edad: "+ edad);
		List<Estudiante> lista= this.estudianteService.buscarPorGenero(genero);
		return lista;
	}
	
	
	//
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/1?prueba=holamundo
	@GetMapping(path = "/buscarMixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id ,@RequestParam String prueba){
		
		System.out.println("Dato: "+ id);
		System.out.println("Dato: "+ prueba);
		return this.estudianteService.buscar(id);
	}
	
	
	
	
	

}
