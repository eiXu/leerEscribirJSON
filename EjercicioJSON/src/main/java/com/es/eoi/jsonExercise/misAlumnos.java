package com.es.eoi.jsonExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class misAlumnos {

	// Nombre del archivo sobre el que escribir y leer
	public static final String ARCHIVO = "ejercicioJSON";

	public static void main(String[] args) {

		// inicializarAlumnos();

		// mostrarJson();

		mostrarAlumnos();

	}

	public static void inicializarAlumnos() {

		// Creación del array
		List<Alumno> alumnos = new ArrayList<Alumno>();

		// Crear asignaturas
		Asignatura matematicas = new Asignatura("Matemáticas");
		Asignatura plastica = new Asignatura("Plástica");
		Asignatura castellano = new Asignatura("Castellano");
		Asignatura ingles = new Asignatura("Inglés");
		Asignatura valenciano = new Asignatura("Valenciano");

		// Añadir calificaciones a los alumnos
		Calificacion calificacionAdrian1 = new Calificacion(5.0, plastica);
		Calificacion calificacionAdrian2 = new Calificacion(9.0, matematicas);
		Calificacion calificacionAdrian3 = new Calificacion(3.0, castellano);

		List<Calificacion> calificacionesAdrian = new ArrayList<Calificacion>();
		calificacionesAdrian.add(calificacionAdrian1);
		calificacionesAdrian.add(calificacionAdrian2);
		calificacionesAdrian.add(calificacionAdrian3);

		Calificacion calificacionJavier1 = new Calificacion(4.0, castellano);
		Calificacion calificacionJavier2 = new Calificacion(5.0, valenciano);
		Calificacion calificacionJavier3 = new Calificacion(6.0, ingles);

		List<Calificacion> calificacionesJavier = new ArrayList<Calificacion>();
		calificacionesJavier.add(calificacionJavier1);
		calificacionesJavier.add(calificacionJavier2);
		calificacionesJavier.add(calificacionJavier3);

		Calificacion calificacionUriel1 = new Calificacion(5.0, plastica);
		Calificacion calificacionUriel2 = new Calificacion(5.0, plastica);
		Calificacion calificacionUriel3 = new Calificacion(5.0, plastica);

		List<Calificacion> calificacionesUriel = new ArrayList<Calificacion>();
		calificacionesUriel.add(calificacionUriel1);
		calificacionesUriel.add(calificacionUriel2);
		calificacionesUriel.add(calificacionUriel3);

		// Añadir alumnos a la lista
		alumnos.add(new Alumno("Adrian", "Ortiz", 25, calificacionesAdrian));
		alumnos.add(new Alumno("Javier", "Perez", 31, calificacionesJavier));
		alumnos.add(new Alumno("Uriel", "Azulejo", 15, calificacionesUriel));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(alumnos);

		try {
			FileWriter fr = new FileWriter(ARCHIVO, false);
			fr.write(json);
			fr.close();
		} catch (IOException e) {
			System.err.println("No existe el archivo");
		}

	}

	public static void mostrarJson() {

		try {
			FileReader reader = new FileReader(ARCHIVO);
			BufferedReader br = new BufferedReader(reader);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			System.err.println("No existe el archivo");
		}

	}

	public static void mostrarAlumnos() {

		String lineasAlumnos = "";

		try {
			FileReader reader = new FileReader(ARCHIVO);
			BufferedReader br = new BufferedReader(reader);

			String linea;
			while ((linea = br.readLine()) != null) {
				lineasAlumnos = lineasAlumnos + linea;
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			System.err.println("No existe el archivo");
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type listType = new TypeToken<ArrayList<Alumno>>() {
		}.getType();
		List<Alumno> alumnos = gson.fromJson(lineasAlumnos, listType);

		System.out.println("Hay " + alumnos.size() + " alumnos");
		for (Alumno alumno : alumnos) {
			System.out.println("Alumno: " + alumno.getNombre());
		}

	}

}
