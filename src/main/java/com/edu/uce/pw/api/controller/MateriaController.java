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


@RequestMapping(path = "/materias")
@RestController
public class MateriaController {
    
    @Autowired
    private IMateriaService materiaService;
    
    @PostMapping
    public void guardar(@RequestBody Materia materia) {
        materiaService.guardar(materia);
    }
    
    @PutMapping(path = "/{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody Materia materia) {
        Materia mater = materiaService.buscar(id);
        if (mater != null) {
            materia.setId(id);
            materiaService.actualizar(materia);
        }
    }
    
    
    @PatchMapping(path = "/{id}")
    public void actualizarParcial(@PathVariable Integer id, @RequestBody Materia materia) {
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
    }
    
    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id) {
        materiaService.borrar(id);
    }
    
    @GetMapping(path = "/{id}")
    public Materia buscar(@PathVariable Integer id) {
        return materiaService.buscar(id);
    }
    
    @GetMapping(path = "/buscarPorCreditos")
    public List<Materia> buscarPorCreditos(@RequestParam(name = "creditos") String creditos) {
     
        if (creditos != null && !creditos.isEmpty()) {
            return materiaService.buscarPorCreditos(creditos);
        } else {          
            return null;
        }
    }
    
    
}
