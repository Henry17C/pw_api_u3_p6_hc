package com.edu.uce.pw.api.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void insertar(Estudiante estudiante) {
	  
	        entityManager.persist(estudiante);
	  
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query= this.entityManager.createQuery("Select  e from Estudiante e where e.genero = :genero  ", Estudiante.class);
		
		query.setParameter("genero", genero);
		return query.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarTodosEstudiantes() {
		// TODO Auto-generated method stub
		
		TypedQuery<Estudiante> query= this.entityManager.createQuery("Select  e from Estudiante e ", Estudiante.class);
		
		return query.getResultList();
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query= this.entityManager.createQuery("Select e from Estudiante e Where e.cedula= :cedula", Estudiante.class);
		query.setParameter("cedula", cedula);
		
		return query.getSingleResult();
		
		
	}
	public void eliminarPorCedula(String cedula) {
	    // Encontrar el estudiante por cédula
	    TypedQuery<Estudiante> estudianteQuery = entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class);
	    estudianteQuery.setParameter("cedula", cedula);
	    
	    Estudiante estudiante;
	    try {
	        estudiante = estudianteQuery.getSingleResult();
	    } catch (NoResultException e) {
	        // Si no se encuentra ningún estudiante con la cédula proporcionada
	        throw new EntityNotFoundException("No se encontró el estudiante con la cédula: " + cedula);
	    }

	    // Eliminar las materias relacionadas primero (asumiendo que la entidad Materia tiene un campo 'estudiante' que es una relación many-to-one)
	    Query deleteMateriasQuery = entityManager.createQuery("DELETE FROM Materia m WHERE m.estudiante.id = :estudianteId");
	    deleteMateriasQuery.setParameter("estudianteId", estudiante.getId());
	    deleteMateriasQuery.executeUpdate();

	    // Eliminar el estudiante
	    entityManager.remove(estudiante);
	}

}
