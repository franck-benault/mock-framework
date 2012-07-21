package net.franckbenault.mockframework.easymock;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
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
	 * 
	 */
	@Test
	public void feature1_returninValueTest() {
		//create mock
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

}
