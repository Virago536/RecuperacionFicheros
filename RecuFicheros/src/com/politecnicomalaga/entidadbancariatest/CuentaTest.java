package com.politecnicomalaga.entidadbancariatest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.politecnicomalaga.entidadbancaria.Cuenta;

public class CuentaTest {
	
	private Cuenta miCuenta;
	private String ccc, ccc2;
	private float saldo,saldo2,ingreso,retirada;
	private String fechaApertura, fechaApertura2;
	
	@BeforeEach
	public void iniciarObjetos() {
		ccc="1234 5678 3300 12345678";
		saldo = 100f;
		fechaApertura = "12/12/2023";
		
		ccc2="1234 5678 3300 12345678";
		saldo2 = 200f;
		ingreso =100f;
		retirada=50f;
		fechaApertura2 = "12/12/2023";
		
		
		miCuenta = new Cuenta(ccc, saldo, fechaApertura);
		
	}
	@Test
	public void testInicialConstructorGetters() {
		assertTrue(miCuenta.getCcc().equals(ccc));
		assertTrue(miCuenta.getSaldo() == saldo);
		assertTrue(miCuenta.getFechaApertura().equals(fechaApertura));

	}
	
	@Test
	public void testSetters() {
		miCuenta.setCcc(ccc2);
		miCuenta.setFechaApertura(fechaApertura2);
		
		assertTrue(miCuenta.getCcc().equals(ccc2));
		assertTrue(miCuenta.getSaldo() == saldo);
		assertTrue(miCuenta.getFechaApertura().equals(fechaApertura2));

	}

	@Test
	public void testIngreso() {
		
		assertTrue(miCuenta.getCcc().equals(ccc));
		assertTrue(miCuenta.getSaldo() == saldo);
		assertTrue(miCuenta.getFechaApertura().equals(fechaApertura));
		
		assertFalse(miCuenta.ingresarEfectivo(0f));
		assertTrue(miCuenta.getSaldo() == saldo);
		
		assertTrue(miCuenta.ingresarEfectivo(ingreso));
		assertTrue(miCuenta.getSaldo() == saldo2);
		
		assertFalse(miCuenta.ingresarEfectivo(-3f));
		assertTrue(miCuenta.getSaldo() == saldo2);
		

	}
	
	@Test
	public void testRetirada() {
		
		assertTrue(miCuenta.getCcc().equals(ccc));
		assertTrue(miCuenta.getSaldo() == saldo);
		assertTrue(miCuenta.getFechaApertura().equals(fechaApertura));
		
		assertFalse(miCuenta.retirarEfectivo(0f));
		assertTrue(miCuenta.getSaldo() == saldo);
		
		assertTrue(miCuenta.retirarEfectivo(retirada));
		assertTrue(miCuenta.getSaldo() == saldo-retirada);
		
		assertTrue(miCuenta.retirarEfectivo(retirada));
		assertTrue(miCuenta.getSaldo() == saldo-retirada*2);
		
		assertFalse(miCuenta.retirarEfectivo(100f));
		assertTrue(miCuenta.getSaldo() == saldo-retirada*2);
		
		assertFalse(miCuenta.retirarEfectivo(-3f));
		assertTrue(miCuenta.getSaldo() == saldo-retirada*2);
		

	}
	
	@Test
	public void isActiva() {
		
		assertTrue(miCuenta.getCcc().equals(ccc));
		assertTrue(miCuenta.getSaldo() == saldo);
		assertTrue(miCuenta.getFechaApertura().equals(fechaApertura));
		
		assertFalse(miCuenta.retirarEfectivo(0f));
		assertTrue(miCuenta.isActiva());
		
		assertTrue(miCuenta.retirarEfectivo(retirada));
		assertTrue(miCuenta.isActiva());
		
		assertTrue(miCuenta.retirarEfectivo(retirada));
		assertFalse(miCuenta.isActiva());
		
		assertTrue(miCuenta.ingresarEfectivo(100f));
		assertTrue(miCuenta.isActiva());
		

	}
	
}
