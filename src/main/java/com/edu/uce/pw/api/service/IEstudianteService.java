package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	 public Estudiante buscar(Integer id);

	 
	 
	 public  void borrar (Integer id);
	
	 public void guardar(Estudiante estudiante);
	 public void actualizar(Estudiante estudiante);
	 
	 List<Estudiante> buscarPorGenero(String genero);
	 
	 public EstudianteTO buscarPorId(Integer id);
	 
	 List<EstudianteTO> seleccionarTodosEstudiantesTO();
	 EstudianteTO buscarPorCedula(String cedula);
	 void  actualizarPorCedula(EstudianteTO estudianteTO);
	 void eliminarPorCedula(String cedula);
	 
	 public void guardarEstudiante(EstudianteTO estudinateTO);
	 

}
