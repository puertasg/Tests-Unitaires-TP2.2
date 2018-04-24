package fr.pizzeria.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class ModifierPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC()
	{
		PizzaMemDao p = new PizzaMemDao();
		ModifierPizzaService mps = new ModifierPizzaService();
		
		systemInMock.provideLines("PEP", "TES", "Test", "11");
		Scanner sc = new Scanner(System.in);
		
		mps.executeUC(sc, p);
		
		assertEquals("TES", p.findAllPizzas().get(0).getCode());
		assertEquals("Test", p.findAllPizzas().get(0).getLibelle());
		assertTrue(p.findAllPizzas().get(0).getPrix() == 11);
	}
}
