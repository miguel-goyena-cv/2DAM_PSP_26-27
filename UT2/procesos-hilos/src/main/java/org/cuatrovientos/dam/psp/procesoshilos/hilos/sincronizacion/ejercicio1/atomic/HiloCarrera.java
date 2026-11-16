package org.cuatrovientos.dam.psp.procesoshilos.hilos.sincronizacion.ejercicio1.atomic;

public class HiloCarrera implements Runnable {
	
	private Contador contadorComun;

	public HiloCarrera(Contador contadorComun) {
		super();
		this.contadorComun = contadorComun;
	}

	@Override
	public void run() {

		for (int i = 0; i< 10000000; i++) {
			this.contadorComun.incrementar();
		}
		
		System.out.println("Acaba hilo: "+Thread.currentThread().getId()+" y el contador es: "+this.contadorComun.getValor());
		
	}

}
