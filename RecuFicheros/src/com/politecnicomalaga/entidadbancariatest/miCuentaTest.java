package com.politecnicomalaga.entidadbancariatest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.politecnicomalaga.entidadbancaria.Cuenta; 

public class miCuentaTest {
	private Cuenta cuenta1;
	
	private String ccc_1, ccc2_1;
	private float saldo_1, saldo2_1, ingreso_1, retirada_1;
	private String fechaApertura_1, fechaApertura2_1;
	
	@BeforeEach
	public void inciarCuenta1() {
		ccc_1 = "1234";
		saldo_1 = 150;
		fechaApertura_1 = "24/11/2024";
		
		ccc2_1= "4321";		
		saldo2_1 = 225;
		ingreso_1 = 75;
		retirada_1 = 25;
		fechaApertura2_1 = "26/11/2024";
		
		cuenta1 = new Cuenta(ccc_1, saldo_1, fechaApertura_1);

	}
	
	@Test
	public void getCcc() {
		assertTrue(cuenta1.getCcc().equals(ccc_1));;
	}

	@Test
	public void setCcc() {
		cuenta1.setCcc(ccc2_1);
		
		assertTrue(cuenta1.getCcc().equals(ccc2_1));
	}

	@Test
	public void getSaldo() {
		assertTrue(cuenta1.getSaldo()==saldo_1);;
	}

	@Test
	public void getFechaApertura() {
		assertTrue(cuenta1.getFechaApertura().equals(fechaApertura_1));;
	}

	@Test
	public void setFechaApertura() {
		cuenta1.setFechaApertura(fechaApertura2_1);
		
		assertTrue(cuenta1.getFechaApertura().equals(fechaApertura2_1));;
	}
	
	@Test
	public void retirarEfectivo() {
		assertTrue(cuenta1.getSaldo() == saldo_1);
		
		assertFalse(cuenta1.retirarEfectivo(0f));
		assertTrue(cuenta1.getSaldo() == saldo_1);
		
		assertTrue(cuenta1.retirarEfectivo(retirada_1));
		assertTrue(cuenta1.getSaldo() == saldo_1-retirada_1);
		
		assertTrue(cuenta1.retirarEfectivo(retirada_1));
		assertTrue(cuenta1.getSaldo() == saldo_1-retirada_1*2);
		
		assertFalse(cuenta1.retirarEfectivo(300f));
		assertTrue(cuenta1.getSaldo() == saldo_1-retirada_1*2);
			
		assertFalse(cuenta1.retirarEfectivo(-50f));
		assertTrue(cuenta1.getSaldo() == saldo_1-retirada_1*2);
		
	}

	@Test
	public void ingresarEfectivo() {
		assertTrue(cuenta1.getSaldo() == saldo_1);
		
		assertFalse(cuenta1.ingresarEfectivo(0f));
		assertTrue(cuenta1.getSaldo() == saldo_1);
		
		assertTrue(cuenta1.ingresarEfectivo(ingreso_1));
		assertTrue(cuenta1.getSaldo() == saldo2_1);
		
		assertTrue(cuenta1.ingresarEfectivo(ingreso_1));
		assertTrue(cuenta1.getSaldo() == saldo2_1+ingreso_1);
		
		assertFalse(cuenta1.retirarEfectivo(-50f));
		assertTrue(cuenta1.getSaldo() == saldo_1+ingreso_1*2);
		
	}

	@Test
	public void isActiva() {
		
		assertTrue(cuenta1.getCcc().equals(ccc_1));
		assertTrue(cuenta1.getSaldo() == saldo_1);
		assertTrue(cuenta1.getFechaApertura().equals(fechaApertura_1));
		
		assertFalse(cuenta1.retirarEfectivo(0f));
		assertTrue(cuenta1.isActiva());
		
		assertTrue(cuenta1.retirarEfectivo(retirada_1));
		assertTrue(cuenta1.isActiva());
		
		assertTrue(cuenta1.ingresarEfectivo(100f));
		assertTrue(cuenta1.isActiva());
		

	}
	
}
