/**
 * 
 */
package testMyStack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import arrayImplementation.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Iterator;
import utilities.StackADT;

/**
 * These are the JUnit tests for every method in the MyStack class. There are
 * multiple tests for each method to ensure that the implementation is
 * completed.
 * 
 * @author Team-Riju
 * 
 * @version Mar 28 2022
 * 
 */
public class MyStackUnitTest {

	StackADT<String> stack;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		stack = null;
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPushEmpty() {
		stack.push("O");

		assertEquals(1, stack.size());
		assertEquals("O", stack.peek());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPushNotEmpty() {
		stack.push("O");
		stack.push("P");

		assertEquals(2, stack.size());

		stack.pop();
		assertEquals("O", stack.peek());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPushNullPointerException() {
		try {
			stack.push(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#pop()}.
	 */
	@Test
	public void testPopNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		String deleted = stack.pop();

		assertEquals(2, stack.size());
		assertEquals("J", deleted);
		assertEquals("I", stack.peek());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#pop()}.
	 */
	@Test
	public void testPopEmptyStackException() {
		try {
			stack.pop();
			fail("EmptyStackException was not thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#peek()}.
	 */
	@Test
	public void testPeekNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		String value = stack.peek();

		assertEquals(3, stack.size());
		assertEquals("J", value);
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#peek()}.
	 */
	@Test
	public void testPeekEmptyStackException() {
		try {
			stack.peek();
			fail("EmptyStackException wasn't thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#clear()}.
	 */
	@Test
	public void testClear() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		assertEquals(3, stack.size());

		stack.clear();

		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmptyNotEmpty() {
		stack.push("R");
		stack.push("I");

		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#toArray()}.
	 */
	@Test
	public void testToArrayEmpty() {
		Object[] arr = stack.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#toArray()}.
	 */
	@Test
	public void testToArrayNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		Object[] arr = stack.toArray();
		assertEquals(4, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertEquals(stack.pop(), arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayEmpty() {
		String[] arr = new String[3];

		arr = stack.toArray(arr);
		assertEquals(3, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		String[] arr = new String[4];

		arr = stack.toArray(arr);
		assertEquals(4, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertEquals(stack.pop(), arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			stack.toArray(null);
		});
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsEmpty() {
		boolean contains = stack.contains("A");

		assertFalse(contains);
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsMatch() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		boolean contains = stack.contains("J");

		assertTrue(contains);
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNotMatch() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		boolean contains = stack.contains("U");

		assertFalse(contains);
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNullPointerException() {
		try {
			stack.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearchEmpty() {
		assertEquals(-1, stack.search("A"));
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearchMatch() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		int depth = stack.search("R");

		assertEquals(3, depth);
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearchNotMatch() {
		stack.push("R");
		stack.push("I");
		stack.push("J");

		assertEquals(-1, stack.search("U"));
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	public void testEqualsStackADTOfEEqual() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		MyStack<String> comparedS = new MyStack<>();
		comparedS.push("R");
		comparedS.push("I");
		comparedS.push("J");
		comparedS.push("U");

		assertTrue(stack.equals(comparedS));
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	public void testEqualsStackADTOfENotEqual() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		MyStack<String> comparedS = new MyStack<>();
		comparedS.push("U");
		comparedS.push("J");
		comparedS.push("I");
		comparedS.push("R");

		assertFalse(stack.equals(comparedS));
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, stack.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#size()}.
	 */
	@Test
	public void testSizeNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		assertEquals(4, stack.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#iterator()}.
	 */
	@Test
	public void testIteratorEmpty() {
		Iterator<String> iterator = stack.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link arrayImplementation.MyStack#iterator()}.
	 */
	@Test
	public void testIteratorNotEmpty() {
		stack.push("R");
		stack.push("I");
		stack.push("J");
		stack.push("U");

		Iterator<String> iterator = stack.iterator();
		assertTrue(iterator.hasNext());

		while (iterator.hasNext()) {
			assertEquals(stack.peek(), iterator.next());
			stack.pop();
		}
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

}
