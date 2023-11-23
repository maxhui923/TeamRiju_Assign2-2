/**
 * 
 */
package testMyQueue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Iterator;
import utilities.QueueADT;
import arrayImplementation.*;
import exceptions.EmptyQueueException;

/**
 * These are the JUnit tests for every method in the MyQueue class. There are
 * multiple tests for each method to ensure that the implementation is
 * completed.
 * 
 * @author Team-Riju
 * @version Nov 20 2023
 * 
 */
public class MyQueueUnitTest {
	QueueADT<String> queue;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyQueue#enqueue(java.lang.Object)}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testEnqueueEmpty() throws EmptyQueueException {
		queue.enqueue("R");

		assertEquals(1, queue.size());
		assertEquals("R", queue.peek());
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyQueue#enqueue(java.lang.Object)}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testEnqueueNotEmpty() throws EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");

		assertEquals(2, queue.size());

		queue.dequeue();
		assertEquals("I", queue.peek());
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueueNullPointerException() {
		try {
			queue.enqueue(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#dequeue()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testDequeueNotEmpty() throws EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");

		String deleted = queue.dequeue();

		assertEquals(1, queue.size());
		assertEquals("R", deleted);
		assertEquals("I", queue.peek());
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#dequeue()}.
	 */
	@Test
	public void testDequeueEmptyQueueException() {
		try {
			queue.dequeue();
			fail("EmptyQueueException was not thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#peek()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testPeekNotEmpty() throws EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");

		String value = queue.peek();

		assertEquals(2, queue.size());
		assertEquals("R", value);
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#peek()}.
	 */
	@Test
	public void testPeekEmptyQueueException() {
		try {
			queue.peek();
			fail("EmptyQueueException wasn't thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#dequeueAll()}.
	 */
	@Test
	public void testDequeueAll() {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		assertEquals(4, queue.size());

		queue.dequeueAll();

		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmptyNotEmpty() {
		queue.enqueue("R");
		queue.enqueue("I");

		assertFalse(queue.isEmpty());
		assertEquals(2, queue.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#iterator()}.
	 */
	@Test
	public void testIteratorEmpty() {
		Iterator<String> iterator = queue.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#iterator()}.
	 * 
	 * @throws EmptyQueueException
	 * @throws NoSuchElementException
	 */
	@Test
	public void testIteratorNotEmpty() throws NoSuchElementException, EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		Iterator<String> iterator = queue.iterator();
		assertTrue(iterator.hasNext());

		while (iterator.hasNext()) {
			assertEquals(queue.peek(), iterator.next());
			queue.dequeue();
		}
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	public void testEqualsQueueADTOfEEqual() {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		MyQueue<String> comparedQ = new MyQueue<>();
		comparedQ.enqueue("R");
		comparedQ.enqueue("I");
		comparedQ.enqueue("J");
		comparedQ.enqueue("U");

		assertTrue(queue.equals(comparedQ));
	}

	/**
	 * Test method for
	 * {@link arrayImplementation.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	public void testEqualsQueueADTOfENotEqual() {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		MyQueue<String> comparedQ = new MyQueue<>();
		comparedQ.enqueue("J");
		comparedQ.enqueue("I");
		comparedQ.enqueue("R");
		comparedQ.enqueue("U");

		assertFalse(queue.equals(comparedQ));
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#toArray()}.
	 */
	@Test
	public void testToArrayEmpty() {
		Object[] arr = queue.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#toArray()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testToArrayNotEmpty() throws EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		Object[] arr = queue.toArray();
		assertEquals(4, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertEquals(queue.dequeue(), arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayEmpty() {
		String[] arr = new String[3];

		arr = queue.toArray(arr);
		assertEquals(3, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#toArray(E[])}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testToArrayEArrayNotEmpty() throws EmptyQueueException {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		String[] arr = new String[4];

		arr = queue.toArray(arr);
		assertEquals(4, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertEquals(queue.dequeue(), arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			queue.toArray(null);
		});
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#isFull()}.
	 */
	@Test
	public void testIsFull() {
		// Optional. Queue designed without fixed length.
		assertTrue(true);
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, queue.size());
	}

	/**
	 * Test method for {@link arrayImplementation.MyQueue#size()}.
	 */
	@Test
	public void testSizeNotEmpty() {
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("J");
		queue.enqueue("U");

		assertEquals(4, queue.size());
	}

}
