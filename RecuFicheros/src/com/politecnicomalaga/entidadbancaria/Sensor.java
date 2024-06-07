package com.politecnicomalaga.entidadbancaria;

import java.util.ArrayList;

public class Sensor {
	
	private String type;
	private int num;
	
	ArrayList<Campo> fields;

	public Sensor(String type, int num) {
		super();
		this.type = type;
		this.num = num;
		
		fields = new ArrayList<>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public boolean creaCampo(Campo campoAgregado) {
		
		if(!estaCampo(campoAgregado.getName())) {
			fields.add(campoAgregado);
			return true;
		}
		return false;
	}
	
	public boolean borraCampo(String name) {
		Campo campoBorrado = buscaCampo(name);
		if(estaCampo(name)) {
			fields.remove(campoBorrado);
			return true;
		}
		
		return false;
	}
	
	
	public boolean estaCampo(String name) {
		return (buscaCampo(name)!=null);
	}
	
	
	public Campo buscaCampo(String name) {
		for(Campo c : fields) {
			if(c.getName().equals(name)) {
				return c;
			}
			
		}
		return null;
	}
	
	
	
	@Override
	public String toString() {
		return "Sensor [type=" + type + ", num=" + num + ", fields=" + fields + "]";
	}
	
}
