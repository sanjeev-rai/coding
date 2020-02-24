package unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import linkedList.QueueUsingList;

public class QueueUsingListTest {

	QueueUsingList st;
	@Before
	public void setUp() throws Exception {
		st = new QueueUsingList();
		st.insert(5);
		st.insert(8);
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(false, st.isEmpty());
	}
	
	@Test
	public void testPop() {
		Assert.assertEquals(5, st.remove());
	}
	
	@Test
	public void testPeek() {
		Assert.assertEquals(5, st.peek());
		st.remove();
		Assert.assertEquals(8, st.peek());
	}

}
