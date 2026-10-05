package org.cuatrovientos.dam.psp.colecciones.ejercicio2.alt4;

import java.util.HashMap;
import java.util.Map;

import org.cuatrovientos.dam.psp.colecciones.ejercicio2.Nota;

public class NotasAlumnos extends HashMap<String, NotasAlumno>{

	/**
	 * Busca la nota ñor alumno y Asignatura
	 * @param alumno
	 * @param asignatura
	 * @return
	 */
	public Nota buscarPorAlumnoYAsignatura(String alumno, String asignatura) {
		
		Nota notaEncontrada = null; // Inicializo a nulo para que si no encuentra nada, me devuelva un nulo
		
		if (this.containsKey(alumno)) {
			NotasAlumno notasAlumno = this.get(alumno);
			notaEncontrada = notasAlumno.buscarNotaPorAsignatura(asignatura);
		}
		
		// En otro caso devuelvo nulo
		return notaEncontrada;
	}

	@Override
	public String toString() {
		
		String representacionString = "";
		
		for (Map.Entry<String, NotasAlumno> entry : this.entrySet()) {
		    String clave = entry.getKey();
		    NotasAlumno valor = entry.getValue();
		    representacionString = representacionString + "Alumno = "+clave+"\n";
		    for (Nota nota: valor) {
		    	representacionString = representacionString + "\t"+ "Asignatura: "+nota.getAsignatura()+", Calificacion: "+nota.getCalificacion() + "\n";
		    }
		    representacionString = representacionString + "===============================================\n";
		}
		
		return representacionString;
	}
	
	
}
