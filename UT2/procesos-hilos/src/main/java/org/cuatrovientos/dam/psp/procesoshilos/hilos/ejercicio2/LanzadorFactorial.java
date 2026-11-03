package org.cuatrovientos.dam.psp.procesoshilos.hilos.ejercicio2;

public class LanzadorFactorial {
	
	private static long timestampInicio = System.currentTimeMillis();

	public static void main(String[] args) {
		
		logConTimestamp("Empieza el programa");
		
		// Reitero por cada número recogido por entrada
		for (int i = 0; i< args.length; i++) {
			
			int numeroCalcular = Integer.parseInt(args[i]);
			
			logConTimestamp("Calculo el número: "+numeroCalcular);
			CalcularFactorial calcRunnable = new CalcularFactorial("Calcular"+i, numeroCalcular, true);
			Thread calculadora = new Thread(calcRunnable);
			calculadora.start();
			try {
				calculadora.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logConTimestamp("Resultado: "+calcRunnable.getResultado());
		}

	}
	
    private static void logConTimestamp(String log){
    	System.out.println("HiloMAIN, Timestamp: "+(System.currentTimeMillis() - timestampInicio)+": "+log);
    }

}
