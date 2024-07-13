package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public  void insertar (Materia materia);
	
	public void actualizar(Materia materia);
	
	public void eliminar(Integer id);
	
	public Materia buscar(Integer id);
	
	public List<Materia> seleccionarPorCreditos(String creditos);
	
	public  List<Materia> seleccionarIdEstudiante(Integer id);
	
	

}
