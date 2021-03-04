package com.prueba.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="socios")
public class Socios {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="socio")
	private String socio ;

	@Column(name="tasa")
	private Double tasa ;

	@Column(name="monto_maximo")
	private Integer montoMaximo ;

	public Socios(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getSocio(){
		return this.socio;
	}

	public void setSocio(String socio){
		this.socio = socio;
	}

	public Double getTasa(){
		return this.tasa;
	}

	public void setTasa(Double tasa){
		this.tasa = tasa;
	}

	public Integer getMontoMaximo(){
		return this.montoMaximo;
	}

	public void setMontoMaximo(Integer montoMaximo){
		this.montoMaximo = montoMaximo;
	}

}