package fr.pizzeria.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	
	PizzaMemDao p;
	
	@Before
	public void setUp()
	{
		this.p = new PizzaMemDao();
	}
	
	@Test
	public void testFindAllPizzas()
	{
		assertTrue(p.findAllPizzas().size() == 8);
	}
	
	@Test
	public void testSaveNewPizza()
	{
		int oldLength = p.findAllPizzas().size();
		Pizza pi = new Pizza("TES", "Test", 11.11);
		p.saveNewPizza(pi);
		
		assertTrue(p.findAllPizzas().size() == oldLength+1);
	}
	
	@Test
	public void testDeletePizza()
	{
		p.deletePizza("PEP");
		assertTrue(p.findAllPizzas().size() == 7);
	}
	
	@After
	public void tearDown()
	{
		this.p = null;
	}
}
