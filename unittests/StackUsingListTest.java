package unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import linkedList.StackUsingList;

public class StackUsingListTest {

	StackUsingList st;
	@Before
	public void setUp() throws Exception {
		st = new StackUsingList();
		st.push(5);
		st.push(8);
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, st.isEmpty());
	}
	
	@Test
	public void testPop() {
		Assert.assertEquals(8, st.pop());
	}
	
	@Test
	public void testPeek() {
		Assert.assertEquals(8, st.peek());
		st.pop();
		Assert.assertEquals(5, st.peek());
	}

}
