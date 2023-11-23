/**
 * 
 */
package testMyDLL;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.*;
import arrayImplementation.MyDLL;

/**
 * These are the JUnit tests for every method in the MyDLL class. There are
 * multiple tests for each method to ensure that the implementation is
 * completed.
 * 
 * @author Team-Riju
 * @version Nov 20 2023
 * 
 */

public class MyDLLUnitTest {

	ListADT<String> dllList;

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dllList = new MyDLL<>();
	}

	/**
	 * tests.
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		dllList = null;
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#size()}. 
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, dllList.size());
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#size()}. 
	 */
	@Test
	public void testSizeNonEmpty() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		assertEquals(3, dllList.size());
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#clear()}. 
	 */
	@Test
	public void testClear() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		assertEquals(3, dllList.size());

		dllList.clear();

		assertEquals(0, dllList.size());
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testAddIntEEmpty() {
		boolean added = dllList.add(0, "O");

		assertTrue(added);
		assertEquals(1, dllList.size());
		assertEquals("O", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testAddIntENonEmptyAppend() {
		dllList.add("O");
		boolean added = dllList.add(1, "P");

		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("P", dllList.get(1));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testAddIntENonEmptyPrepend() {
		dllList.add("P");
		boolean added = dllList.add(0, "O");

		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("O", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testAddIntENonEmptyInsert() {
		dllList.add("D");
		dllList.add("F");
		boolean added = dllList.add(1, "E");

		assertTrue(added);
		assertEquals(3, dllList.size());
		assertEquals("E", dllList.get(1));

	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testAddIntENullPointerException() {
		try {
			dllList.add(0, null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEEmpty() {
		boolean added = dllList.add("O");

		assertTrue(added);
		assertEquals(1, dllList.size());
		assertEquals("O", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(java.lang.Object)}.
	 * DLL.
	 */
	@Test
	public void testAddENonEmpty() {
		dllList.add("O");
		boolean added = dllList.add("P");

		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("P", dllList.get(1));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddENullPointerException() {
		try {
			dllList.add(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#addAll(arrayImplementation
	 * .ListADT)}. 
	 */
	@Test
	public void testAddAllEmpty() {
		MyDLL<String> newList = new MyDLL<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");

		boolean added = dllList.addAll(newList);

		assertTrue(added);
		assertEquals("D", dllList.get(0));
		assertEquals(3, dllList.size());
		assertEquals("E", dllList.get(1));
		assertEquals("F", dllList.get(2));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#addAll(arrayImplementation
	 * .ListADT)}. 
	 */
	@Test
	public void testAddAllNonEmpty() {
		dllList.add("J");
		dllList.add("A");

		MyDLL<String> newList = new MyDLL<>();
		newList.add("V");
		newList.add("A");

		boolean added = dllList.addAll(newList);

		assertTrue(added);
		assertEquals(4, dllList.size());
		assertEquals("J", dllList.get(0));
		assertEquals("A", dllList.get(1));
		assertEquals("V", dllList.get(2));
		assertEquals("A", dllList.get(3));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#addAll(arrayImplementation
	 * .ListADT)}. 
	 */
	@Test
	public void testAddAllNullPointerException() {
		try {
			dllList.addAll(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#get(int)}. 
	 */
	@Test
	public void testGetEmpty() {
		try {
			dllList.get(0);
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#get(int)}. 
	 */
	@Test
	public void testGetNonEmpty() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		String value = dllList.get(2);

		assertEquals("P", value);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(int)}. 
	 */
	@Test
	public void testRemoveIntEmpty() {
		try {
			dllList.remove(0);
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(int)}. 
	 */
	@Test
	public void testRemoveIntOnlyOneNode() {
		dllList.add("O");

		String deleted = dllList.remove(0);

		assertEquals(0, dllList.size());
		assertEquals("O", deleted);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(int)}. 
	 */
	@Test
	public void testRemoveIntFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String deleted = dllList.remove(0);

		assertEquals("A", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(int)}. 
	 */
	@Test
	public void testRemoveIntLastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String deleted = dllList.remove(2);

		assertEquals("C", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEEmpty() {
		String deleted = dllList.remove("O");

		assertEquals(0, dllList.size());
		assertNull(deleted);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEWhenOnlyOneNode() {
		dllList.add("O");

		String deleted = dllList.remove("O");

		assertEquals(0, dllList.size());
		assertEquals("O", deleted);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String deleted = dllList.remove("A");

		assertEquals("A", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveELastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String deleted = dllList.remove("C");

		assertEquals("C", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEDuplicatedNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		dllList.add("B");
		dllList.add("D");

		String deleted = dllList.remove("B");

		assertEquals("B", deleted);
		assertEquals(4, dllList.size());
		assertEquals("A", dllList.get(0));
		assertEquals("C", dllList.get(1));
		assertEquals("B", dllList.get(2));
		assertEquals("D", dllList.get(3));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENotContain() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		String deleted = dllList.remove("G");

		assertEquals(3, dllList.size());
		assertNull(deleted);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENullPointerException() {
		try {
			dllList.remove(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#set(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testSetEmpty() {
		try {
			dllList.set(0, "O");
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#set(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testSetFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String preValue = dllList.set(0, "D");

		assertEquals("A", preValue);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(0));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#set(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testSetLastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");

		String preValue = dllList.set(2, "D");

		assertEquals("C", preValue);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(2));
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#set(int,
	 * java.lang.Object)}. 
	 */
	@Test
	public void testSetNullPointerException() {
		try {
			dllList.add("A");
			dllList.set(0, null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#isEmpty()}. 
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(dllList.isEmpty());
		assertEquals(0, dllList.size());
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#isEmpty()}. 
	 */
	@Test
	public void testIsEmptyNotEmpty() {
		dllList.add("O");
		dllList.add("P");

		assertFalse(dllList.isEmpty());
		assertEquals(2, dllList.size());
	}

	/**
	 * Test method for {@link arrayImplementation
	 * .MyDLL#contains(java.lang.Object)}. 
	 */
	@Test
	public void testContainsEmpty() {
		boolean contains = dllList.contains("O");

		assertFalse(contains);
	}

	/**
	 * Test method for {@link arrayImplementation
	 * .MyDLL#contains(java.lang.Object)}. 
	 */
	@Test
	public void testContainsMatch() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		boolean contains = dllList.contains("P");

		assertTrue(contains);
	}

	/**
	 * Test method for {@link arrayImplementation
	 * .MyDLL#contains(java.lang.Object)}. 
	 */
	@Test
	public void testContainsNoMatch() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		boolean contains = dllList.contains("G");

		assertFalse(contains);
	}

	/**
	 * Test method for {@link arrayImplementation
	 * .MyDLL#contains(java.lang.Object)}. 
	 */
	@Test
	public void testContainsNullPointerException() {
		try {
			dllList.contains(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#toArray(E[])}. 
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			dllList.toArray(null);
		});
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#toArray()}. 
	 */
	@Test
	public void testToArrayEmpty() {
		Object[] arr = dllList.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#toArray()}. 
	 */
	@Test
	public void testToArrayNonEmpty() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		Object[] arr = dllList.toArray();
		assertEquals(3, arr.length);

		for (int i = 0; i < arr.length; i++) {
			assertEquals(dllList.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#iterator()}.
	 */
	@Test
	public void testIteratorEmpty() {
		Iterator<String> iterator = dllList.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link arrayImplementation .MyDLL#iterator()}. 
	 */
	@Test
	public void testIteratorNonEmpty() {
		dllList.add("O");
		dllList.add("O");
		dllList.add("P");

		Iterator<String> iterator = dllList.iterator();
		assertTrue(iterator.hasNext());
		int i = 0;
		while (iterator.hasNext()) {
			assertEquals(dllList.get(i++), iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

}
