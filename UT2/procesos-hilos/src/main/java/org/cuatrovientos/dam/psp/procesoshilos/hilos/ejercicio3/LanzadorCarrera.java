package org.cuatrovientos.dam.psp.procesoshilos.hilos.ejercicio3;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LanzadorCarrera {
	
	private static final Duration TIEMPO_ITERACION = Duration.ofSeconds(1);
	private static long timestampInicio;
	
	public static void main(String[] args) {
		
		try {
			
			timestampInicio = System.currentTimeMillis();
			logConTimestamp("Empezamos la carrera!!!");
			
			// Vamos a crear los participantes y lanzar su carrera
			Map<Participante, Thread> hilosParticipantes = new HashMap<>();
			crearParticipantes(hilosParticipantes);
			
			// Mientras esperamos a que acaben vigilamos cada segundo si tenemos que penalizar al primero
			// TODO  me falta encapsular un poco
			boolean continuar = true;
			while (continuar) {
				
				// Esperamos 1 segundo entre bucles
				Thread.sleep(TIEMPO_ITERACION.getSeconds()*1000);
				
				// Calculamos el contador del primero y del segundo
				int contadorPrimero = 0;
				Participante participantePrimero = null;
				int contadorSegundo = 0;
				Participante participanteSegundo = null;
				for (Map.Entry<Participante, Thread> participante : hilosParticipantes.entrySet()) {

					Thread hiloParticipante = participante.getValue();
					Participante infoParticipante = participante.getKey();
					
					// Si el hilo ha acabado y se ha llegado al final es que ha ganado
					if (!hiloParticipante.isAlive() && infoParticipante.getContador() == ConfiguracionCarrera.LONGITUD_CARRERA) {
						logConTimestamp("Tenemos Ganador: "+infoParticipante.toString());
						continuar = false;
						break;
					}
					
					// Veo si es primero o segundo
					if (infoParticipante.getContador() >= contadorPrimero) {
						contadorPrimero = infoParticipante.getContador();
						participantePrimero = infoParticipante;
					}
					else if (infoParticipante.getContador() >= contadorSegundo){
						contadorSegundo = infoParticipante.getContador();
						participanteSegundo = infoParticipante;
					}
				}
				
				// Evaluamos la diferencia entre primero y segundo, pero OJO que puede que haya salido del bucle por encontrar el ganador
				if ((participantePrimero != null && participanteSegundo != null) && (participantePrimero.getContador() - participanteSegundo.getContador()) > ConfiguracionCarrera.MAXIMA_DIFERENCIA_SEGUNDO) {
					// Frenamos al primero!!!
					logConTimestamp("Frenamos a "+participantePrimero.getNombre()+ " que va muy deprisa");
					participantePrimero.frenar();
				}
				
			}
			
			//TODO posible mejora, puedo parar el resto de los hilos sin que acaben sus carreras
			
		}
		catch (Exception e){
			System.err.println("Problema grande durante la carrera, abortamos: "+e.getMessage());
			e.printStackTrace();
		}

	}

	private static void crearParticipantes(Map<Participante, Thread> hilosParticipantes) {

		for (int i = 0; i < ConfiguracionCarrera.NUMERO_PARTICIPANTES; i++) {
			Participante participante = new Participante("Participante"+i, ConfiguracionCarrera.LONGITUD_CARRERA);
			Thread hiloParticipante = new Thread(participante); 
			hiloParticipante.start();
			hilosParticipantes.put(participante, hiloParticipante);
		}
		
	}
	
	/**
     * Escribe el log junto con los ms desde comienzo hilo
     * @param log
     */
    private static void logConTimestamp(String log){
    	System.out.println("[Organizador] Timestamp: "+(System.currentTimeMillis() - timestampInicio)+": "+log);
    }
	

}
