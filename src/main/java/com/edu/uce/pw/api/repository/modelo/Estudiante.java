package com.edu.uce.pw.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
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
	
	//Get Y SET
	public Integer getId() {
		return id;
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
