package org.cuatrovientos.dam.psp.procesoshilos.procesos;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploLanzarTrabajoPesado {

	public static void main(String[] args) {

		String claseTrabajoPesado = "org.cuatrovientos.dam.psp.procesoshilos.procesos.TrabajoPesado";
		
		try {
			
			// Creo una instancia del ProcessBuilder
			System.out.println("Creo instancia del ProcessBuilder");
			ProcessBuilder lanzadorProcesoSuma = new ProcessBuilder(Arrays.asList("java", claseTrabajoPesado));
			lanzadorProcesoSuma.directory(new File(".\\target\\classes"));
			
			
	        int hilos = Runtime.getRuntime().availableProcessors();
	        hilos = 13;
	        
	        List<Process> misTrabajadores= new ArrayList<>();
	        for (int i = 0; i< hilos ; i++) {
	    		System.out.println("Ahora lanzo el proceso");
	    		misTrabajadores.add(lanzadorProcesoSuma.start());
	        }
	        
	        Thread.sleep(20000);
	        
	        for (Process process : misTrabajadores) {
				process.destroy();
			}
	        
			
			
		}
		catch (Exception e) {
			System.err.println("Error en el programa principal: "+e.getMessage());
			e.printStackTrace();
		}
		

	}

}
