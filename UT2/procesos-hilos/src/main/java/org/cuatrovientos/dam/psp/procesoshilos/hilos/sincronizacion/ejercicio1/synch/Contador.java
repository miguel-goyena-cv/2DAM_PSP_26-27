package org.cuatrovientos.dam.psp.procesoshilos.hilos.sincronizacion.ejercicio1.synch;

public class Contador {
	
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int getValor() {
        return contador;
    }
	

}
