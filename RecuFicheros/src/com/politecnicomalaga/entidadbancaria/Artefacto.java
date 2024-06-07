package com.politecnicomalaga.entidadbancaria;

import java.util.ArrayList;

public class Artefacto {

	private String artifact, architecture;
	private int productID;
	
	ArrayList<Sensor> sensors;

	public Artefacto(String artifact, String architecture, int productID) {
		this.artifact = artifact;
		this.architecture = architecture;
		this.productID = productID;
		
		sensors = new ArrayList<>();
	}

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
	public Sensor buscaSensor(int num) {
		if(sensors==null) {
			return null;
		}
		for(Sensor s : sensors) {
			
			if(s.getNum()==num) {
				return s;
			}
			
		}
		return null;
	}
	
	public boolean agregaSensor(Sensor s) {
		if(buscaSensor(s.getNum())==null) {
			sensors.add(s);
			return true;
		}
		else return false;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "Artefacto [artifact=" + artifact + ", architecture=" + architecture + ", productID=" + productID
				+ ", sensors=" + sensors + "]";
	}
	
	
	
	
	
}
