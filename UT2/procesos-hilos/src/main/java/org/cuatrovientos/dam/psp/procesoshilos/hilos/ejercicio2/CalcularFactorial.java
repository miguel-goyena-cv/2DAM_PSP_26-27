package org.cuatrovientos.dam.psp.procesoshilos.hilos.ejercicio2;

import java.math.BigInteger;

public class CalcularFactorial implements Runnable {
	
	private String nombre;
	private int numeroCalcular;
	private boolean conLogs; // Indica si tengo que imprimir logs en mi funcionamiento.
	private long timestampInicio;
	private BigInteger resultado;
	

	public CalcularFactorial(String nombre, int numeroCalcular, boolean conLogs) {
		super();
		this.nombre = nombre;
		this.numeroCalcular = numeroCalcular;
		this.conLogs = conLogs;
	}

	@Override
    public void run() {
		
        timestampInicio= System.currentTimeMillis();
        logConTimestamp("Iniciando el cálculo del factorial de: "+this.numeroCalcular);

        // Cálculo del factorial utilizando BigInteger
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= this.numeroCalcular; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            logConTimestamp("Voy multiplicando en concreto: "+i);
        }
        
        logConTimestamp("Cálculo finalizado: "+numeroCalcular);
        
        resultado = fact;
       
    }
	
    private void logConTimestamp(String log){
    	if (conLogs)
    		System.out.println("Hilo: "+nombre+"; Timestamp: "+(System.currentTimeMillis() - timestampInicio)+": "+log);
    }

	public BigInteger getResultado() {
		return resultado;
	}


}
