package com.prueba.backend.vo;

public class SociosVo {

	private Integer id ;

	private String socio ;

	private Double tasa ;

	private Integer montoMaximo ;
	
	private Double cuotaMensual;
	
	private Double pagoTotal;
	
	public SociosVo(){
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
	
	public Double getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(Double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public Double getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(Double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}

}