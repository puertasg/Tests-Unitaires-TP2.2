package fr.pizzeria.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class AjouterPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC()
	{
		PizzaMemDao p = new PizzaMemDao();
		AjouterPizzaService aps = new AjouterPizzaService();
		
		systemInMock.provideLines("TES", "Test", "11");
		Scanner sc = new Scanner(System.in);
		
		aps.executeUC(sc, p);
		
		assertEquals("TES", p.findAllPizzas().get(8).getCode());
		assertEquals("Test", p.findAllPizzas().get(8).getLibelle());
		assertTrue(p.findAllPizzas().get(8).getPrix() == 11);
	}
}
