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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

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
	 * feature1bis of mock framework
	 * call a method returning void
	 */
	@Test
	public void feature1b_returninValueVoidTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = mock(List.class);
		 
		//expectation
		doNothing().when(mockList).clear();
		 
		//business test
		mockList.clear();
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
	
	/*
	 * feature2 bis of mock framework
	 * throwing an exception
	 */
	@Test(expected=RuntimeException.class)
	public void feature2bis_VoidReturnThrowingExceptionTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = mock(List.class);
		 
		//expectation
		doThrow(new RuntimeException()).when(mockList).clear();
		
		//business test
		mockList.clear();

	}

	
	/*
	 * feature3 of mock framework
	 * counting invocation
	 */
	@Test
	public void feature3_countingInvocationTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = mock(List.class);
		 
		//expectation
		when(mockList.get(0)).thenReturn("val");
		//expect(mockList.get(0)).andReturn("val").times(1,3);
		

		 
		//business test
		assertEquals(mockList.get(0),"val");
		assertEquals(mockList.get(0),"val");
		assertEquals(mockList.get(0),"val");
		//I expect that get(0) is called maximum three times
		//assertEquals(mockList.get(0),"val");

		//verify
		//possible verifyAll();
		verify(mockList, atLeast(1)).get(0);
		verify(mockList, atMost(3)).get(0);
	}
	
}
