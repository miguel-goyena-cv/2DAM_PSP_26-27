package org.cuatrovientos.dam.psp.herencia.ejercicio1;

import java.time.Duration;

public class Consultor extends Empleado {
	
	private Duration tiempoTrabajado; // VER EL API de DURATION, es muy interesante.
	private float precioHora;
	
	
	public Consultor(String nombre, String puesto, String direccion, String nSS, float sueldoBruto, float impuestos,
			Duration tiempoTrabajado, float precioHora) {
		super(nombre, puesto, direccion, nSS, sueldoBruto, impuestos);
		this.tiempoTrabajado = tiempoTrabajado;
		this.precioHora = precioHora;
	}
	
	public float calcularPaga () {
		return precioHora * tiempoTrabajado.toHours();
	}


	public long getHorasTrabajadas() {
		return tiempoTrabajado.toHours();
	}


	public void setTiempoTrabajado(Duration tiempoTrabajado) {
		this.tiempoTrabajado = tiempoTrabajado;
	}


	public float getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}


	@Override
	public String toString() {
		return "Consultor [horas=" + tiempoTrabajado + ", precioHora=" + precioHora + ", inherited()=" + super.toString() + "]";
	}
	
	

}
