package com.trivera.demo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDumpFile {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
		Customer c = new Customer("Draco", "Malfoy", "+44 0206 444-1313", "draco@malfoy.co.uk");
		c = WeasleyConsoleStore.insertCustomerIntoDatabase(c);
		assertTrue("Customer ID should be a positive number!", c.getCustomerId() > 0);
	}

	@Test
	public void testListCustomers() {
	}

}
