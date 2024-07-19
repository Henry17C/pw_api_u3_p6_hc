package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	
	//CRUD
	
	  Estudiante seleccionar(Integer id);

	  void actualizar(Estudiante estudiante);
	 
	   void eliminar (Integer id);
	
	  void insertar(Estudiante estudiante);
	 
	  List<Estudiante> seleccionarPorGenero(String genero);
	 List<Estudiante> seleccionarTodosEstudiantes();
	 
	 Estudiante seleccionarPorCedula(String cedula);
	 
	 public void eliminarPorCedula(String cedula);

	 
}
