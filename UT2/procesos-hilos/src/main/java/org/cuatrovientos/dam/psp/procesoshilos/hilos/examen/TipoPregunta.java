package org.cuatrovientos.dam.psp.procesoshilos.hilos.examen;

import java.time.Duration;
import java.util.Random;


public enum TipoPregunta {
	
	VERDADERO_FALSO("Verdadero o Falso", Duration.ofSeconds(20), Duration.ofSeconds(40), "1"),
	RESPUESTA_CORTA("Respuesta Corta", Duration.ofSeconds(60), Duration.ofSeconds(80), "2"),
	NO_TYPE("Sin Tipo", null, null, null);
	
	
    private final String descripcion;
    private final Duration tiempoRespuestaMinimo; 
    private final Duration tiempoRespuestaMaximo; 
    private final String indice;

    TipoPregunta(String descripcion, Duration tiempoRespuestaMinimo,  Duration tiempoRespuestaMaximo, String indice) {
		this.descripcion = descripcion;
		this.tiempoRespuestaMinimo = tiempoRespuestaMinimo;
		this.tiempoRespuestaMaximo = tiempoRespuestaMaximo;
		this.indice = indice;
	}

	public String getDescripcion() {
		return descripcion;
	}


	public Duration getTiempoRespuestaMinimo() {
		return tiempoRespuestaMinimo;
	}
	
	public Duration getTiempoRespuestaMaximo() {
		return tiempoRespuestaMaximo;
	}

	public String getIndice() {
		return indice;
	}

	/**
	 * Devuelve el menu de TiposPreguntas
	 * @return
	 */
	public static String montarMenuTipos() {
		
		String resultadoMenu = "";
		for (TipoPregunta tipo : TipoPregunta.values()) {
			if (tipo != TipoPregunta.NO_TYPE)
				resultadoMenu = resultadoMenu+tipo.indice+".- "+ tipo.descripcion+ "\n";
		}
		
		return resultadoMenu;

	}

	public static  TipoPregunta getTipoDeIndice(String indice) {
		for (TipoPregunta tipo : TipoPregunta.values()) {
			if (tipo.indice == null) { // Eso es el tipo vacio
				continue;
			}
			if (tipo.indice.equals(indice)) {
				return tipo;
			}
		}
		return TipoPregunta.NO_TYPE;
		
	}

	/**
	 * Es un aleatorio entre el minimo y el maximo
	 * @return
	 */
	Duration calcularTiempoRespuestaPregunta() {
		Random rnd = new Random();
		long secondsAleatorio = rnd.nextLong(this.tiempoRespuestaMinimo.toSeconds(), this.tiempoRespuestaMaximo.toSeconds());
		return Duration.ofSeconds(secondsAleatorio);
	}

}
