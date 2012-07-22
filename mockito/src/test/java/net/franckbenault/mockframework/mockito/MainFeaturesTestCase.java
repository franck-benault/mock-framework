package net.franckbenault.mockframework.mockito;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainFeaturesTestCase {

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

	/*
	 * feature1 of mock framework
	 * returning a value
	 */
	@Test
	public void feature1_returninValueTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = mock(List.class);
		 
		//expectation
		when(mockList.get(0)).thenReturn("one");
		

		//business test
		assertEquals(mockList.get(0),"one");


	}
	
	/*
	 * feature2 of mock framework
	 * throwing an exception
	 */
	@Test(expected=RuntimeException.class)
	public void feature2_throwingExceptionTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = mock(List.class);
		 
		//expectation
		when(mockList.get(0)).thenThrow(new RuntimeException());
	
		//business test
		mockList.get(0);

	}

}
