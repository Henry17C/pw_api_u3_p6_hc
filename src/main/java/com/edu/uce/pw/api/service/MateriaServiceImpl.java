package com.edu.uce.pw.api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;


@Service
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		iMateriaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		iMateriaRepository.actualizar(materia);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		iMateriaRepository.eliminar(id);
	}

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return iMateriaRepository.buscar(id);
	}

	@Override
	public List<Materia> buscarPorCreditos(String creditos) {
		// TODO Auto-generated method stub
		return iMateriaRepository.seleccionarPorCreditos(creditos);
	}
	
	

}
