package org.cuatrovientos.dam.psp.herencia.ejercicio2;

public class Informatico extends Corredor {
	
	private final int VELOCIDAD = 7;

	public Informatico(String nombre) {
		super(nombre);
	}

	@Override
	protected void correr() {
		System.out.println("Corro a "+VELOCIDAD);
	}

}
