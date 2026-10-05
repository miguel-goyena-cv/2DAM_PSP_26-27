package org.cuatrovientos.dam.psp.colecciones.ejercicio1.alt1;

import java.time.Duration;
import java.util.List;

public class Principal {
	
	static Recetario recetas;

	public static void main(String[] args) {
		
		// Rellenamos la BBDD
		rellenarRecretas();
		
		// Mostrar recetas
		System.out.println("Lista de recetas: ");
		System.out.println(recetas.toString());
		System.out.println("======================================");
		
		// Buscar por postre
		List<Receta> recetasPostre = recetas.buscarPorTipo(TipoReceta.Postre);
		System.out.println("Lista de recetas de tipo: "+ TipoReceta.Postre);
		System.out.println(recetasPostre.toString());
		System.out.println("======================================");
		
		// Eliminamos por nombre
		recetas.eliminarRecetaPorNombre("Pizza");
		System.out.println("Lista de recetas despues de eliminar la PIZZA: ");
		System.out.println(recetas.toString());
		System.out.println("======================================");
		
	}


	private static void rellenarRecretas() {
		
		recetas = new Recetario("Abuela");
		
		Receta recetaPizza = new Receta("Pizza", Duration.ofMinutes(60), TipoReceta.Principal);
		Receta recetaEnsalada = new Receta("Ensalada verde", Duration.ofMinutes(10), TipoReceta.Entrante);
		Receta recetaPanTumaca = new Receta("Pan Tumaca", Duration.ofSeconds(45), TipoReceta.Entrante);
		Receta recetaALeche = new Receta("Arroz con leche", Duration.ofMinutes(30), TipoReceta.Postre);
		Receta recetaTiramisu = new Receta("Hamburguesa del Fosters", Duration.ZERO, TipoReceta.Principal);
		
		recetas.anadirReceta(recetaTiramisu);
		recetas.anadirReceta(recetaALeche);
		recetas.anadirReceta(recetaPanTumaca);
		recetas.anadirReceta(recetaEnsalada);
		recetas.anadirReceta(recetaPizza);
		
	}

}
