package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;
import com.edu.uce.pw.api.service.to.MateriaTO;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Cache;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/materias")

public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	
	
	
	
	
	
	
	/*
	
	  EJEMPLO ERRONEO
	//http://localhost:8080/API/v1.0/Matricula/materias/3/materias GET   ///ESTE LINK NO CUMPLE EL NIVE 1 DEL MADUREZ DE RICHARDSON
	 * 
	 * 
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO>  buscarMateriaPorIdEstudiante(@PathVariable Integer id){
		return this.materiaService.buscarPorIdEstudiante(id);
	}
	
	
	
	*/
	
	
	
	
	  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
		  	HttpHeaders headers= new HttpHeaders();
		  	headers.add("mensaje_200", "Materia insertada");
	        materiaService.guardar(materia);
	       
	       // return ResponseEntity.status(200).body(materia);
	        return new ResponseEntity<Materia>(materia, headers,200);
	    }
	    
	    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Materia> actualizar(@PathVariable Integer id, @RequestBody Materia materia) {
	    	HttpHeaders headers= new HttpHeaders();
	    	headers.add("mensaje_238","Materia actualizada");
	        Materia mater = materiaService.buscar(id);
	        if (mater != null) {
	            materia.setId(id);
	            materiaService.actualizar(materia);
	        }
	       // return ResponseEntity.status(238).body(materia);
	        
	        return new ResponseEntity<Materia>(materia, headers, 238);
	    }
	    
	    
	    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Materia> actualizarParcial(@PathVariable Integer id, @RequestBody Materia materia) {
	        Materia mater = materiaService.buscar(id);
	        HttpHeaders headers= new HttpHeaders();
	        headers.add("mensaje_239", "Materia actuailzada pacialmente");
	        
	        if (mater != null) {
	            if (materia.getNombre() != null) {
	                mater.setNombre(materia.getNombre());
	            }
	            
	            if (materia.getNumeroCreditos() != null) {
	                mater.setNumeroCreditos(materia.getNumeroCreditos());
	            }            
	            materiaService.actualizar(mater);
	        }
	        
	        //return ResponseEntity.status(239).body(materia);
	        return new ResponseEntity<Materia> (materia, headers, 239);
	    }
	    
	    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> borrar(@PathVariable Integer id) {
	        materiaService.borrar(id);
	        HttpHeaders headers= new  HttpHeaders();
	        headers.add("mensaje_240", "Materia borrada");
	        //return ResponseEntity.status(240).body("Borrado");
	        
	        return new ResponseEntity<String>("Borrado", headers,240);
	    }
	    
	    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Materia> buscar(@PathVariable Integer id) {
	    	Materia m= materiaService.buscar(id);
	    	
	    	HttpHeaders headers= new HttpHeaders();
	    	// return ResponseEntity.status(236).body(m);
	    	
	    	return new ResponseEntity<Materia>(m, headers, 236);
	    }

	//http://localhost:8080/API/v1.0/Matricula/materias?creditos=4
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Materia>> getMateriasCreditos(@RequestParam String creditos) {
		List<Materia> li= materiaService.buscarPorCreditos(creditos);
		return ResponseEntity.status(200).body(li);
	}
	
	

	

}
