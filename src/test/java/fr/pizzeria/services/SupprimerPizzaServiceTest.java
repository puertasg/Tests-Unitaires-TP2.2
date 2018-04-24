package fr.pizzeria.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class SupprimerPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC()
	{
		PizzaMemDao p = new PizzaMemDao();
		SupprimerPizzaService sps = new SupprimerPizzaService();
		
		systemInMock.provideLines("PEP");
		Scanner sc = new Scanner(System.in);
		
		sps.executeUC(sc, p);
		
		assertTrue(p.findAllPizzas().size() == 7);
	}
}