package org.cuatrovientos.dam.psp.herencia.ejercicio2;

public class Deportista extends Corredor {
	
	private final int VELOCIDAD = 15;

	public Deportista(String nombre) {
		super(nombre);
	}

	@Override
	protected void correr() {
		System.out.println("Corro a "+VELOCIDAD);
	}

}
