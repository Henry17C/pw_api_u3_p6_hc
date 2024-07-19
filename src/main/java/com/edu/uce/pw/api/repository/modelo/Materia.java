package com.edu.uce.pw.api.repository.modelo;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Materia")
@JsonIncludeProperties(value="estudiante")
public class Materia {
	
	@Id
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@Column(name = "mate_id")
	private Integer id ;
	
	@Column(name = "mate_nombre")
	private String nombre;

	
	@Column(name = "mate_codigo")
	private String codigo;

	
	@Column(name = "mate_numero_creditos")
	private Integer numeroCreditos;

	
	
	@Column(name = "mate_cedula_profesor")
	private String cedulaProfesor;



	public Integer getId() {
		return id;
	}

	@ManyToOne()
	@JoinColumn(name="mate_id_estudiante")
	private Estudiante estudiante;


	public Estudiante getEstudiante() {
		return estudiante;
	}



	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}



	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}



	public String getCedulaProfesor() {
		return cedulaProfesor;
	}



	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}
	
	
	//get y set
	
	
	
	
	
	
	
	

}
