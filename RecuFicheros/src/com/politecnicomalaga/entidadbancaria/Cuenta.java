package com.politecnicomalaga.entidadbancaria;

public class Cuenta {
	
	private String ccc; //Código de la cuenta
	private float saldo;
	private String fechaApertura;
	
	
	public Cuenta(String ccc, float saldo, String fechaApertura) {
		super();
		this.ccc = ccc;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public float getSaldo() {
		return saldo;
	}


	public String getFechaApertura() {
		return fechaApertura;
	}


	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	public boolean isActiva() {
		return saldo>0;
	}
	
	public boolean retirarEfectivo(float cantidad) {
		if (cantidad <= 0) return false;
		if (cantidad <= saldo) {
			saldo -= cantidad;
			return true;
		}
		return false;
	}

	public boolean ingresarEfectivo(float cantidad) {
		if (cantidad <= 0) return false;
		saldo += cantidad;
		return true;
	}
	

}
