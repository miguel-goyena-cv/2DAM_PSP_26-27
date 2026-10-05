package org.cuatrovientos.dam.psp.colecciones.ejercicio1.alt1;

import java.util.ArrayList;
import java.util.List;

public class Recetario {
	
	private List<Receta> recetas;
	String nombre;

	public Recetario(String nombre) {
		super();
		recetas = new ArrayList<>();
		this.nombre = nombre;
	}
	
	public void anadirReceta(Receta nuevaReceta) {
		this.recetas.add(nuevaReceta);
	}
	
	public void eliminarRecetaPorNombre(String nombreEliminar) {
		
		// Vamos a utilizar predicados lambda, YUJUU!!!
		recetas.removeIf(r -> r.getNombre().equals(nombreEliminar));
	}
	
	public List<Receta> buscarPorTipo(TipoReceta tipo) {

		List<Receta> resultado = new ArrayList<>();
		
		// Realizamos la busqueda.
		for (Receta receta : recetas) {
			if (receta.getTipo().equals(tipo)) {
				resultado.add(receta);
			}
		}
		
		return resultado;
	}
	
	public String toString() {
		return recetas.toString();
	}

}
