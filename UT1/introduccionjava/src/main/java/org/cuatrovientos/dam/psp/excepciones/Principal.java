package org.cuatrovientos.dam.psp.excepciones;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		try (Scanner scanner =  new Scanner(System.in)) {
			
			System.out.println("Bienvenido a la calculadora de numeros naturales: ");
			
	        // Preparamos el bucle para repetir la operación
	        boolean continuar = true;
	        while (continuar) {

	        	// Pedimos los numeros por pantalla y creamos el objeto TODO Podriamos pasarlo a la calculadora ???
	        	CalculadoraNaturales cn = pedirDatosOperadores(scanner);
	        	
	        	// Hago la operacion de resta solo en el caso en que este montada correctamente la calculadora
	        	if (cn != null) {
		            try {
		            	int resultado = cn.resta();
		            	System.out.println("Resultado: "+resultado);
		            }
		            catch (NegativeSubstractException e1) {
		            	System.out.println("Resultado negativo!!: "+e1.getMessage());
		            }
		            // No quiero hacer un catch de esto porque es RunTime y tengo que hacer algo para que no pase nuenca
		            // He realizado validaciones anteriormente.
//		            catch (IllegalArgumentException e2) {
//		            	System.out.println(e2.getMessage());
//					}
	        	}

	            // Pregunto si quiero otra operacion
	            System.out.print("Quiere realizar otra operación (S/n): ");
	            String respuesta = scanner.nextLine();
	            continuar = (respuesta.equalsIgnoreCase("s"));
	            
	        }
		}
		catch (Exception e) {
			System.out.println("Error general en el programa: "+e.getMessage());
			e.printStackTrace();
		}

	}

	private static CalculadoraNaturales pedirDatosOperadores(Scanner scanner) {
		
		//Variable de metodo
		boolean errorValidacion = false;
		int num1 = 0;
		int num2 = 0;
		
		//Pido y valido los datos del primer numero
		System.out.print("Introduce el primer número: ");
		try {
			num1 = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e ) {
			System.out.println("Introduce un numero cenutrio!!");
			errorValidacion = true;
			return null;
		}
		if (num1<0) {
			System.out.println("Introduce un numero mayor a 0");
			errorValidacion = true;
			return null;
		}
		
		//Pido y valido los datos del segundo numero TODO Estoy repitiendo codigo ??
		System.out.print("Introduce el segundo número: ");
		try {
			num2 = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e ) {
			System.out.println("Introduce un numero cenutrio!!");
			errorValidacion = true;
			return null;
		}
		if (num2<0) {
			System.out.println("Introduce un numero mayor a 0");
			errorValidacion = true;
			return null;
		}
		
		// Decido mi respuesta
		if (errorValidacion) {
		    return null;
		}
		return new CalculadoraNaturales(num1, num2);
	}

}
