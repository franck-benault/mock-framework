package net.franckbenault.mockframework.easymock;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

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
		List mockList = createNiceMock(List.class);
		 
		//expectation
		expect(mockList.get(0)).andStubReturn("one");
		
		//replay mode
		//possible replayAll()
		replay(mockList);
		 
		//business test
		assertEquals(mockList.get(0),"one");

		//verify
		//possible verifyAll();
		verify(mockList);
	}

	/*
	 * feature1bis of mock framework
	 * call a method returning void
	 */
	@Test
	public void feature1b_returninValueVoidTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = createNiceMock(List.class);
		 
		//expectation
		mockList.clear();
		
		//replay mode
		//possible replayAll()
		replay(mockList);
		 
		//business test
		mockList.clear();

		//verify
		//possible verifyAll();
		verify(mockList);
	}
	
	/*
	 * feature2 of mock framework
	 * throwing an exception
	 */
	@Test(expected=RuntimeException.class)
	public void feature2_throwingExceptionTest() {
		//create mock
		@SuppressWarnings("rawtypes")
		List mockList = createNiceMock(List.class);
		 
		//expectation
		expect(mockList.get(0)).andThrow(new RuntimeException());
		
		//replay mode
		//possible replayAll()
		replay(mockList);
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
		List mockList = createNiceMock(List.class);
		 
		//expectation
		mockList.clear();
		expectLastCall().andThrow(new RuntimeException());
		
		//replay mode
		//possible replayAll()
		replay(mockList);
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
		List mockList = createNiceMock(List.class);
		 
		//expectation
		expect(mockList.get(0)).andReturn("val").times(1,3);
		
		//replay mode
		//possible replayAll()
		replay(mockList);
		 
		//business test
		assertEquals(mockList.get(0),"val");
		assertEquals(mockList.get(0),"val");
		assertEquals(mockList.get(0),"val");
		//I expect that get(0) is called maximum three times
		//assertEquals(mockList.get(0),"val");

		//verify
		//possible verifyAll();
		verify(mockList);
	}
	
}
