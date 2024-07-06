package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	//Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	//recuerda que el post es una de las excepciones en la nomenclatura
	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {

		this.estudianteService.guardar(est);
		
		return ResponseEntity.status(201).body(est);
		
		
	};
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	// Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	///en el postman ya no lleva el id
	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est,  @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);
	};
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	// Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PatchMapping(path = "/{id}")
	public  ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est,  @PathVariable Integer id) {
		est.setId(id);
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
		
		
		
		return ResponseEntity.status(239).body(est2);
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	//Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		
		this.estudianteService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");
		
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1
	//Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@GetMapping(path = "/{id}")
	
	public Estudiante buscarPorId(@PathVariable Integer id) {
		
	return	this.estudianteService.buscar(id);
	};
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/2/nuevo/hola

	@GetMapping(path = "/buscar/{id}/nuevo/{dato}")
	public Estudiante buscar2(@PathVariable Integer id, @PathVariable String dato) {
		System.out.println("dato: "+ dato);
	return	this.estudianteService.buscar(id);
	};
	
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M
	//una de las exepciones del modelo de Richardson, no colocar en infinitivo 
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F
	
	@GetMapping(path  = "/genero")
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
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/1?prueba=holamundo
	@GetMapping(path = "/mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id ,@RequestParam String prueba){
		
		System.out.println("Dato: "+ id);
		System.out.println("Dato: "+ prueba);
		return this.estudianteService.buscar(id);
	}
	
	//EL END POINT NO TIENE QUE SE AMBIGUO, EN DARSE ESTE CASO ME DA ERRORES AMBIGUOS MAPPING
	
	
	

}
