/**
 * 
 */
package testMyArrayList;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import arrayImplementation.MyArrayList;
import utilities.Iterator;
import utilities.ListADT;

/**
 * @author Team-Riju
 * @version Nov 20 2023
 */
public class MyArrayListUnitTest {
	ListADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	public void testSizeNonEmpty() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");

		
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#clear()}.
	 */
	@Test
	public void testClear() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");
		
		assertEquals(4, list.size());
		
		list.clear();
		
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEEmpty() {
		boolean added = list.add(0, "J");
		
		assertTrue(added);
		assertEquals(1, list.size());
		assertEquals("J", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEAppend() {
		list.add("J");
		boolean added = list.add(1, "A");
				
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("A", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEPrepend() {
		list.add("A");
		boolean added = list.add(0, "J");
		
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("J", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEInsert() {
		list.add("J");
		list.add("V");
		boolean added = list.add(1, "A");
		
		assertTrue(added);
		assertEquals(3, list.size());
		assertEquals("A", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntENullPointerException() {
		try {
			list.add(0, null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEEmpty() {
		boolean added = list.add("J");
		
		assertTrue(added);
		assertEquals(1, list.size());
		assertEquals("J", list.get(0));
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddENotEmpty() {
		list.add("J");
		boolean added = list.add("A");
		
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("A", list.get(1));
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddENullPointerException() {
		try {
			list.add(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAllEmpty() {
		MyArrayList<String> newList = new MyArrayList<>();
		newList.add("J");
		newList.add("A");
		newList.add("V");
		newList.add("A");
		
		boolean added = list.addAll(newList);
		
		assertTrue(added);
		assertEquals(4, list.size());
		assertEquals("J", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("V", list.get(2));
		assertEquals("A", list.get(3));

	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAllNotEmpty() {
		list.add("J");
		list.add("A");
		
		MyArrayList<String> newList = new MyArrayList<>();
		newList.add("V");
		newList.add("A");
		
		boolean added = list.addAll(newList);
		
		assertTrue(added);
		assertEquals(4, list.size());
		assertEquals("J", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("V", list.get(2));
		assertEquals("A", list.get(3));
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	public void testAddAllNullPointerException() {
		try {
			list.addAll(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetEmpty() {
		try {
			list.get(0);
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetNotEmpty() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		String value = list.get(2);
		
		assertEquals("V", value);	}
	

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntEmpty() {
		try {
			list.remove(0);
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntoOnlyOneE() {
		list.add("J");

		String deleted = list.remove(0);
		
		assertEquals(0, list.size());
		assertEquals("J", deleted);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntFirstE() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");

		
		String deleted = list.remove(0);
		
		assertEquals("J", deleted);
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntLastE() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");
		
		String deleted = list.remove(3);
		
		assertEquals("A", deleted);
		assertEquals(3, list.size());
		assertEquals("V", list.get(2));	}
	

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveE() {
		String deleted = list.remove("J");
		
		assertEquals(0, list.size());
		assertNull(deleted);
		
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEOnlyOneE() {
		list.add("J");
		
		String deleted = list.remove("J");
		
		assertEquals(0, list.size());
		assertEquals("J", deleted);
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEFirstE() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");

		
		String deleted = list.remove("J");
		
		assertEquals("J", deleted);
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveELastE() {
		list.add("J");
		list.add("A");
		list.add("V");

		
		String deleted = list.remove("V");
		
		assertEquals("V", deleted);
		assertEquals(2, list.size());
		assertEquals("A", list.get(1));	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEuplicatedE() {
		list.add("J");
		list.add("A");
		list.add("V");
		list.add("A");
		list.add("G");
		
		String deleted = list.remove("A");
		
		assertEquals("A", deleted);
		assertEquals(4, list.size());
		assertEquals("J", list.get(0));
		assertEquals("V", list.get(1));
		assertEquals("A", list.get(2));
		assertEquals("G", list.get(3));	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENotIn() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		String deleted = list.remove("S");
		
		assertEquals(3, list.size());
		assertNull(deleted);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENullPointerException() {
		try {
			list.remove(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetEmpty() {
		try {
			list.set(0, "J");
			fail("IndexOutOfBoundsException was not thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetFirstE() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		String preValue = list.set(0, "A");
		
		assertEquals("J", preValue);
		assertEquals(3, list.size());
		assertEquals("A", list.get(0));	
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetLastE() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		String preValue = list.set(2, "A");
		
		assertEquals("V", preValue);
		assertEquals(3, list.size());
		assertEquals("A", list.get(2));	
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetNullPointerException() {
		try {
			list.add("J");
			list.set(0, null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmptyNotEmpty() {
		list.add("J");
		list.add("A");
		
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsEmpty() {
		boolean contains = list.contains("B");
		
		assertFalse(contains);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsMatch() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		boolean contains = list.contains("A");
		
		assertTrue(contains);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNotMatch() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		boolean contains = list.contains("G");
		
		assertFalse(contains);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNullPointerException() {
		try {
			list.contains(null);
			fail("NullPointerException was not thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertNull(arr[i]);
		}	
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNotEmpty() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		String[] arr = new String[3];
		
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}	
	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			list.toArray(null);
			});
	}
	

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);	}
	
	/**
	 * Test method for {@link arrayimplementation.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArrayNotEmpty() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#iterator()}.
	 */
	@Test
	public void testIteratorEmpty() {
		Iterator<String> iterator = list.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});	}

	/**
	 * Test method for {@link arrayimplementation.MyArrayList#iterator()}.
	 */
	@Test
	public void testIteratorNotEmpty() {
		list.add("J");
		list.add("A");
		list.add("V");
		
		Iterator<String> iterator = list.iterator();
		assertTrue(iterator.hasNext());
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(list.get(i++), iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});	}
}
