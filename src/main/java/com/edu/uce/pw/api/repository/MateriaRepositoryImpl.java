package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		entityManager.merge(materia);
	}

	@Override
	public void eliminar(Integer id) {
		entityManager.remove(this.buscar(id));
		
	}

	@Override
	public Materia buscar(Integer id) {
		return entityManager.find(Materia.class, id);
	}

	@Override
	public List<Materia> seleccionarPorCreditos(String creditos) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query= entityManager.createQuery("Select m from Materia m where m.numeroCreditos = :creditos", Materia.class);
		query.setParameter("creditos",creditos);
		return query.getResultList();
	}

	@Override
	public List<Materia> seleccionarIdEstudiante(Integer id) {
		String sentencia= "Select m from Materia m  where m.estudiante.id = :id";
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery(sentencia, Materia.class);
		
		query.setParameter("id", id);
		return query.getResultList();
	}

}
