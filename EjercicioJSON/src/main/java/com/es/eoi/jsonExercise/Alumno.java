package com.es.eoi.jsonExercise;

import java.util.List;

public class Alumno {

	private String nombre;
	private String apellido;
	private int edad;
	private List<Calificacion> notas;

	public Alumno(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Alumno(String nombre, String apellido, int edad, List<Calificacion> notas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.notas = notas;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Calificacion> getNotas() {
		return notas;
	}

	public void setNotas(List<Calificacion> notas) {
		this.notas = notas;
	}

}
