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
		int oldlength = p.findAllPizzas().size();
		Pizza pi = new Pizza("TES", "Test", 11.11);
		p.saveNewPizza(pi);
		
		assertTrue(p.findAllPizzas().size() == oldlength+1);
	}
	
	@Test
	public void testDeletePizza()
	{
		int oldlength = p.findAllPizzas().size();
		p.deletePizza("PEP");
		
		assertTrue(p.findAllPizzas().size() == oldlength-1);
	}
	
	@After
	public void tearDown()
	{
		this.p = null;
	}
}
