package org.cuatrovientos.dam.psp.procesoshilos.hilos.ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LanzadorFactorialConcurrente {
	
	private static long timestampInicio = System.currentTimeMillis();

	public static void main(String[] args) {
		
		logConTimestamp("Empieza el programa");
		Map<Thread, CalcularFactorial> hilosEjecutandose = new HashMap<Thread, CalcularFactorial>();
		
		// Reitero por cada número recogido por entrada
		for (int i = 0; i< args.length; i++) {
			
			int numeroCalcular = Integer.parseInt(args[i]);
			
			logConTimestamp("Calculo el número: "+numeroCalcular);
			
			// Creo Runnables e Hilos
			CalcularFactorial calcRunnable = new CalcularFactorial("Calcular"+i, numeroCalcular, true);
			Thread calculadora = new Thread(calcRunnable);
			hilosEjecutandose.put(calculadora, calcRunnable);
			
			// Ejecuto los hilos y no espero
			calculadora.start();
			
		}
		
		
		// Esperamos a que acaben todos los hilos
		for (Entry<Thread, CalcularFactorial> hiloEjecutandose: hilosEjecutandose.entrySet()) {
			try {
				hiloEjecutandose.getKey().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logConTimestamp("Resultado: "+hiloEjecutandose.getValue().getResultado());
		}
		

	}
	
    private static void logConTimestamp(String log){
    	System.out.println("HiloMAIN, Timestamp: "+(System.currentTimeMillis() - timestampInicio)+": "+log);
    }

}
