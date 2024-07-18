package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;
@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}

	
	public EstudianteTO convertir(Estudiante estu) {
		
		EstudianteTO estTo= new  EstudianteTO();
		estTo.setApellido(estu.getApellido());
		estTo.setGenero(estu.getGenero());
		estTo.setId(estu.getId());
		estTo.setNombre(estu.getNombre());
		
		
		return estTo;
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return  this.convertir(this.buscar(id));
	}

	@Override
	public List<EstudianteTO> seleccionarTodosEstudiantesTO() {
		// TODO Auto-generated method stub
		List<Estudiante> estudiantes= this.estudianteRepository.seleccionarTodosEstudiantes();
		List<EstudianteTO> estudianteTOs= new ArrayList<>();
		for(Estudiante estudiante : estudiantes ) {
			EstudianteTO estudianteTO= this.convertir(estudiante);
			estudianteTOs.add(estudianteTO);
		}
		return estudianteTOs;
	}
}
