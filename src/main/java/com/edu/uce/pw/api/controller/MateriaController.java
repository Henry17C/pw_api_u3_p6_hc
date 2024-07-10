package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	
	  @PostMapping
	    public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
	        materiaService.guardar(materia);
	        return ResponseEntity.status(200).body(materia);
	    }
	    
	    @PutMapping(path = "/{id}")
	    public ResponseEntity<Materia> actualizar(@PathVariable Integer id, @RequestBody Materia materia) {
	        Materia mater = materiaService.buscar(id);
	        if (mater != null) {
	            materia.setId(id);
	            materiaService.actualizar(materia);
	        }
	        return ResponseEntity.status(238).body(materia);
	    }
	    
	    
	    @PatchMapping(path = "/{id}")
	    public ResponseEntity<Materia> actualizarParcial(@PathVariable Integer id, @RequestBody Materia materia) {
	        Materia mater = materiaService.buscar(id);
	        
	        if (mater != null) {
	            if (materia.getNombre() != null) {
	                mater.setNombre(materia.getNombre());
	            }
	            
	            if (materia.getNumeroCreditos() != null) {
	                mater.setNumeroCreditos(materia.getNumeroCreditos());
	            }            
	            materiaService.actualizar(mater);
	        }
	        return ResponseEntity.status(239).body(materia);
	    }
	    
	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity<String> borrar(@PathVariable Integer id) {
	        materiaService.borrar(id);
	        return ResponseEntity.status(240).body("Borrado");
	    }
	    
	    @GetMapping(path = "/{id}")
	    public ResponseEntity<Materia> buscar(@PathVariable Integer id) {
	    	Materia m= materiaService.buscar(id);
	        return ResponseEntity.status(236).body(m);
	    }

	//http://localhost:8080/API/v1.0/Matricula/materias?creditos=4
	@GetMapping()
	public ResponseEntity<List<Materia>> getMateriasCreditos(@RequestParam String creditos) {
		List<Materia> li= materiaService.buscarPorCreditos(creditos);
		return ResponseEntity.status(200).body(li);
	}
	
	

	

}
