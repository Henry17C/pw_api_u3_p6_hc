package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
//@JsonIncludeProperties(value="materias")
public class Estudiante {

	@Id
	@SequenceGenerator(name= "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@Column(name="est_id")
	private Integer id;
	
	@Column(name="est_nombre")
	private String nombre;
	
	@Column(name="est_apellido")
	private String apellido;
	
	@Column(name="est_decha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	@Column(name="est_genero")
	private String genero;
	
	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;
	
	
	//Get Y SET
	
	
	public List<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	public Integer getId() {
		return id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
	
	
}
