package fr.pizzeria.services;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.dao.PizzaMemDao;

public class AuRevoirServiceTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule();
	
	@Test
	public void testExecuteUC()
	{
		AuRevoirService ars = new AuRevoirService();
		PizzaMemDao p = new PizzaMemDao();
		Scanner sc = new Scanner(System.in);
		
		systemOutRule.enableLog();
		
		ars.executeUC(sc, p);
		
		assertEquals("Au revoir\n", systemOutRule.getLogWithNormalizedLineSeparator());
	}
}
