package com.politecnicomalaga.entidadbancaria;

import java.util.Scanner;

import com.google.gson.Gson;

import java.util.Map;
import java.util.HashMap;

public class Main {

	private static Artefacto miArtefacto;
	private static Sensor elSensor;
	
	
	public static void main(String Args[]) {
		
		
		//Atributos artefacto
		String atrArtifact, atrArquitecture;
		int atrProductID = 0;
		
		//Atributos sensor
		String atrType;
		int atrNum = 0;
		
		
		//Atributos campo
		String atrName = null;
		String atrUnit = null;
		int atrDecPrecision = 0;
		
		
		//Atributos fichero
		String ruta;
		Artefacto artGuardado = null;
		Sensor sensGuardado = null;
		Campo campoGuardado = null;
		
		
		Sensor sensorBorrado = null;
		Artefacto artMod = null;
		Sensor sensorMod = null;
		
		Scanner sc = new Scanner(System.in);
		String resp = "X";
		int respInt = 0;
		
		HashMap<Integer,Artefacto> mapaArtefactos;
		
		mapaArtefactos = new HashMap<>();
		
		
		//Sensor sensor1 = new Sensor("sensPrueba", 111);
		
		//Artefacto art1 = new Artefacto("prueba", "unaArquitectura", "123");
		
		//mapaArtefactos.put(art1.getProductID(), art1);
		
		while(resp.compareTo("H")!=0) {
			System.out.println("-----------------------");
			System.out.println("ARTEFACTOS");
			System.out.println("-----------------------");
			System.out.println("A. Añadir artefacto (desde fichero json, entrada: nombre del fichero)");
			System.out.println("B. Añadir Sensor al artefacto. (entrada: nombre del fichero, ProductID)");
			System.out.println("C. Borrar Sensor del artefacto (entrada: clave del artefacto, clave del sensor, que sería “num”)");
			System.out.println("D. Añadir campo al sensor (entrada: código del artefacto, código del sensor, datos del campo)");
			System.out.println("E. Borrar campo del sensor (entrada: código del artefacto, código del sensor, nombre del campo)");
			System.out.println("F. Grabar a JSON Artefacto (entrada: nombre del fichero, código del artefacto)");
			System.out.println("G. Grabar a JSON Sensor (entrada: nombre del fichero, código del artefacto y código del sensor)");
			System.out.println("H. Salir");
			System.out.println("-----------------------");
			
			resp = sc.nextLine();
			
			switch(resp) {
			case "A":
				System.out.println("Introduzca el nombre del fichero del artefacto que desea cargar");
				ruta = sc.nextLine();	
				if(!ruta.isBlank()) {
					boolean comprobacion = false;
					
					comprobacion = GestorJSON.cargarArtefacto(mapaArtefactos, ruta);
					
					if(comprobacion) {
						System.out.println("Artefacto añadido correctamente");
					}else {
						System.out.println("No se pudo agregar el artefacto");
					}
				}
				
				
				
				
				/*System.out.println("Introduzca el nombre del fichero del artefacto que desea cargar");
				ruta = sc.nextLine();
				if(!ruta.isBlank()) {
					String json = ControladorFicheros.readText(ruta);
					
					Gson gson = new Gson();
					miArtefacto = gson.fromJson(json, Artefacto.class);
					if(miArtefacto != null && !mapaArtefactos.containsValue(miArtefacto)) {
						mapaArtefactos.put(miArtefacto.getProductID(), miArtefacto);
						System.out.println("Artefacto agregado correctamente");
					}
					else {
						System.out.println("No se pudo agregar el artefacto");
					}
					
				}*/
				
				break;
			case "B":
				System.out.println("Introduzca el ID del artefacto en el que se va a cargar el sensor");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Formato de ID no válido");
					break;
				}
				
				System.out.println("Introduzca el nombre del fichero del que se va a cargar el sensor");
				ruta = sc.nextLine();
				
				miArtefacto = mapaArtefactos.get(atrProductID);
				if(miArtefacto.buscaSensor(atrNum)!=null) {
					System.out.println("Ya hay un sensor con ese tipo en el artefacto");
				}else {
					if(!ruta.isBlank() && mapaArtefactos.containsKey(atrProductID)) {
						boolean cargado = false;
						
						cargado = GestorJSON.cargarSensor(miArtefacto, ruta);
						if(cargado) {
							System.out.println("Sensor agregado correctamente");
						}else {
							System.out.println("No se pudo agregar el sensor");
						}
						
						
					}else {
						System.out.println("No se pudo agregar el sensor");
					}
				}
				
				break;
			case "C":
				System.out.println("Introduzca el ID del artefacto");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Formato de ID no válido");
					break;
				}
				System.out.println("Introduzca el número del sensor a borrar");
				try {
					atrNum = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				miArtefacto = mapaArtefactos.get(atrProductID);
				if(miArtefacto.buscaSensor(atrNum)!=null) {
					sensorBorrado=miArtefacto.buscaSensor(atrNum);
					miArtefacto.sensors.remove(sensorBorrado);
					System.out.println("Sensor eliminado correctamente");
				}else {
					System.out.println("No se pudo eliminar el sensor");
				}
				
				break;
			case "D":
				System.out.println("Introduzca el ID del artefacto");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				System.out.println("Introduzca el número del sensor");
				try {
					atrNum = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				
				if(mapaArtefactos.containsKey(atrProductID)) {
					artMod = mapaArtefactos.get(atrProductID);
					
					if(artMod.buscaSensor(atrNum)!=null) {
						sensorMod = artMod.buscaSensor(atrNum);
						while(atrName==null) {
							System.out.println("Introduzca el nombre del campo");
							atrName = sc.nextLine();
							if(sensorMod.buscaCampo(atrName)!=null) {
								atrName=null;
								System.out.println("Ya existe un campo con ese nombre");
							}
						}
						while(atrUnit==null) {
							System.out.println("Introduzca la unidad del campo");
							atrUnit = sc.nextLine();
							if(atrUnit.length()>1 || atrUnit.length()<1){
								atrUnit = null;
								System.out.println("Unidad no válida");
							}
						}
						System.out.println("Introduzca el decPrecision");
						atrDecPrecision = Integer.valueOf(sc.nextLine());
						campoGuardado = new Campo(atrName, atrUnit, atrDecPrecision);
						
						if(sensorMod.creaCampo(campoGuardado)==true) {
							System.out.println("Campo guardado correctamente");
							atrName=null;
							atrUnit=null;
						}else {
							System.out.println("No se pudo guardar el campo");
						}
						
						
					}else {
						System.out.println("El sensor no existe");
					}
					
				
				}
				else {
					System.out.println("El artefacto no existe");
				}
				
				
				
				break;
			case "E":
				System.out.println("Introduzca el ID del artefacto");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				System.out.println("Introduzca el número del sensor");
				try {
					atrNum = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				if(mapaArtefactos.containsKey(atrProductID)) {
					artMod = mapaArtefactos.get(atrProductID);
					System.out.println("Introduzca el nombre del campo a borrar");
					if(artMod.buscaSensor(atrNum)!=null) {
						sensorMod = artMod.buscaSensor(atrNum);
						System.out.println("Introduzca el nombre del campo a borrar");
						atrName = sc.nextLine();
						if(sensorMod.buscaCampo(atrName)!=null) {
							sensorMod.borraCampo(atrName);
						}else {
							System.out.println("No se pudo borrar el campo");
						}
					}
					
					
				}else {
					System.out.println("El sensor no existe");
				}
				break;
			case "F":
				System.out.println("Introduzca el nombre del fichero del artefacto que desea guardar");
				ruta = sc.nextLine();
				System.out.println("Introduzca el ID del artefacto a guardar");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				
				if(mapaArtefactos.get(atrProductID)!=null) {
					artGuardado = mapaArtefactos.get(atrProductID);
					
					boolean grabado = false;
					grabado = GestorJSON.grabarArtefacto(artGuardado, ruta);
					if(grabado) {
						System.out.println("Artefacto grabado correctamente");
					}else {
						System.out.println("No se pudo grabar el artefacto");
					}
					
				}
				
				break;
			case "G":
				System.out.println("Introduzca el nombre del fichero en el que desea guardar el sensor");
				ruta = sc.nextLine();
				System.out.println("Introduzca el ID del artefacto");
				try {
					atrProductID = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				System.out.println("Introduzca el número del sensor");
				try {
					atrNum = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número no válido");
					break;
				}
				artGuardado = mapaArtefactos.get(atrProductID);
				if(artGuardado!=null) {
					if(artGuardado.buscaSensor(atrNum)!=null) {
						Sensor sensorGuardado = artGuardado.buscaSensor(atrNum);
						boolean grabado = false;
						
						grabado = GestorJSON.grabarSensor(sensorGuardado, ruta);
						if(grabado) {
							System.out.println("Sensor guardado correctamente");
						}
						
						
					}else {
						System.out.println("No se pudo guardar el sensor");
					}
					
					
					
				}else {
					System.out.println("No se pudo guardar el artefacto");
				}
				
				break;
			case "H":
				System.out.println("Adios");
				break;
					
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
