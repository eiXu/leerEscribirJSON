package com.es.eoi.jsonExercise;

public class Calificacion {

	private Double nota;
	private Asignatura materia;

	public Calificacion(Double nota, Asignatura materia) {
		super();
		this.nota = nota;
		this.materia = materia;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Asignatura getMateria() {
		return materia;
	}

	public void setMateria(Asignatura materia) {
		this.materia = materia;
	}

}
