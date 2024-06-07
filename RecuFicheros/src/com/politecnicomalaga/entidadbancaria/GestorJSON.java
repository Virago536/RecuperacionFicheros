package com.politecnicomalaga.entidadbancaria;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;


public class GestorJSON {
	
	public static boolean cargarSensor(Artefacto art, String jsonfile) {
		try {
			Gson gson = new Gson();
			String jsonLeer = ControladorFicheros.readText(jsonfile);
			Sensor sensorAgregado = gson.fromJson(jsonLeer, Sensor.class);
			if(art.buscaSensor(sensorAgregado.getNum())!=null) {
				return false;
			}else {
				art.agregaSensor(sensorAgregado);
				return true;
			}
		}catch (NullPointerException nul) {
			return false;
		}
		
		
		
	}
	
	
	public static boolean grabarSensor(Sensor sen, String jsonfile) {
		try {
			Gson gson = new Gson();
			String datosSen = gson.toJson(sen);
			
			if(!jsonfile.isBlank()) {
				ControladorFicheros.writeText(jsonfile+".json", datosSen, true);
				return true;
			}else {
				return false;
			}
			
		}catch (NullPointerException nul) {
			return false;
		}
		
		
		
		
	}
	

	
	
	
	
	public static boolean grabarArtefacto(Artefacto art, String jsonFile) {
		try {
			Gson gson = new Gson();
			String datosArt =gson.toJson(art);
			
			if(!jsonFile.isBlank()) {
				ControladorFicheros.writeText(jsonFile+".json", datosArt, true);
				return true;
			}else {
				return false;
			}
			
		}catch (NullPointerException nul) {
			return false;
		}
		
		
		
			
	}
	

	
	
	
	
	public static boolean cargarArtefacto(Map<Integer,Artefacto> destino, String jsonFile) {
		try {
			Gson gson = new Gson();
			String jsonLeer = ControladorFicheros.readText(jsonFile);
			Artefacto artefactoAgregado = gson.fromJson(jsonLeer, Artefacto.class);
			destino.put(artefactoAgregado.getProductID(), artefactoAgregado);
			return true;
			
		}catch (NullPointerException nul) {
			return false;
		}
		
		
		
		

	}

	
	
}
