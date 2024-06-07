package com.politecnicomalaga.entidadbancaria;

public class Campo {
	private String name, unit;
	private int decPrecision;
	
	
	public Campo(String name, String unit, int decPrecision) {
		super();
		this.name = name;
		this.unit = unit;
		this.decPrecision = decPrecision;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public int getDecPrecision() {
		return decPrecision;
	}


	public void setDecPrecision(int decPrecision) {
		this.decPrecision = decPrecision;
	}


	@Override
	public String toString() {
		return "Campo [name=" + name + ", unit=" + unit + ", decPrecision=" + decPrecision + "]";
	}
	
	
}
