package mx.com.bankaya.pokedex.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PETICIONES")
public class Peticion {

	@Id
	private String idPeticion;
	
	@Column(name = "IP_ORIGEN")
	private String ipOrigen;
	
	@Column(name = "FECHA_PETICION")
	private LocalDate fechaPeticion;
	
	@Column(name = "METODO")
	private String metodo;

	public String getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}

	public String getIpOrigen() {
		return ipOrigen;
	}

	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	public LocalDate getFechaPeticion() {
		return fechaPeticion;
	}

	public void setFechaPeticion(LocalDate fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
}
