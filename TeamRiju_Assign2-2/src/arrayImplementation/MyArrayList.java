package arrayImplementation;

import java.lang.reflect.Array;
import utilities.ListADT;
import utilities.Iterator;
import java.util.NoSuchElementException;

/**
 * Utility class for implementing a dynamic array-based list.
 * 
 * This class provides methods for manipulating an array list, including
 * adding, removing, and retrieving elements, as well as iterator functionality.
 * 
 * @author Team-Riju
 * 
 * @version Nov 20, 2023
 * @param <E> The type of element this list contains
 */

@SuppressWarnings("serial")
public class MyArrayList <E> implements ListADT<E>{
	
	private E[] array;
	private int size;
	
	/**
	 * Constructs an empty MyArrayList with an initial capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[10];
	}

	/**
	 * Returns the current number of elements in the list.
	 * 
	 * @return The current element count
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Removes all elements from the list, making it empty.
	 */
	@Override
	public void clear() {
		for(int i=0; i < size; i++) {
			array[i] = null;
		}
		
		size = 0;
	}

	/**
	 * Inserts the specified element at the specified position in the list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).
	 * 
	 * @param index The index at which the specified element is to be inserted
	 * @param toAdd The element to be inserted
	 * @return true if the element is added successfully
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		// Check for capacity
		if(size == array.length) {
			// Create a new array (twice the size of the original)
			E[] newArray = (E[]) new Object[array.length * 2];
			// Use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			// Get the array to reference the new array
			array = newArray;
		}
		
		// Insert toAdd into the specified index position
		for(int j=size-1; j >= index; j--) {
			array[j+1] = array[j];
		}
		
		array[index] = toAdd;
		size++;
		
		return true;
	}

	/**
	 * Appends the specified element to the end of the list.
	 * 
	 * @param toAdd The element to be appended to the list
	 * @return true if the element is appended successfully
	 * @throws NullPointerException if the specified element is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		// Check for capacity
		if(size == array.length) {
			// Create a new array (twice the size of the original)
			E[] newArray = (E[]) new Object[array.length * 2];
			// Use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			// Get the array to reference the new array
			array = newArray;
		}
		
		array[size] = toAdd;
		size++;
		
		return true;
	}
	
	/**
	 * Appends all elements of the specified list to the end of this list.
	 * 
	 * @param toAdd The new sub list to be added
	 * @return true if the operation is successful
	 * @throws NullPointerException if the specified list is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		// Check for capacity
		if(size == array.length) {
			E[] newArray = (E[]) new Object[array.length + toAdd.size()];
			// Use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			// Get the array to reference the new array
			array = newArray;
		}
		
		int j=0;
		for(int i=size; i < size+toAdd.size(); i++) {
			array[i] = toAdd.get(j++);
		}
		
		size = size + toAdd.size();
		
		return true;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index The index of the element to return
	 * @return The element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}
	
	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index The index of the element to remove
	 * @return The removed element
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E deleted = array[index];
		for(int i=index; i < size; i++) {
			array[i] = array[i+1];
		}
		
		size--;
		
		return deleted;
	}

	/**
	 * Removes the first occurrence in this list of the specified element.
	 * 
	 * @param toRemove The element to be removed from this list
	 * @return The element being removed, or null if the list does not contain the element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException();
		}
		
		E deleted = null;
		int index;
		for(index=0; index < size; index++) {
			if(array[index].equals(toRemove)) {
				deleted = array[index];
				
				for(int i=index; i < size; i++) {
					array[i] = array[i+1];
				}
				
				size--;
				break;
			}
		}
		
		return deleted;
	}

	/**
	 * Replaces the element at the specified position in the list with the specified element.
	 * 
	 * @param index The index of the element to replace
	 * @param toChange The element to be stored at the specified position
	 * @return The element previously at the specified position
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toChange == null) {
			throw new NullPointerException();
		}
		
		E changed = array[index];
		
		array[index] = toChange;
		
		return changed;
	}
	
	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if the list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param toFind The element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		for(int i=0; i < size; i++) {
			if(array[i].equals(toFind)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns an array containing all elements of this list in proper sequence.
	 * 
	 * @param toHold The array into which the elements of this list are to be stored,
	 *               if it is big enough; otherwise, a new array of the same runtime type
	 *               is allocated for this purpose
	 * @return An array containing the elements of this list
	 * @throws NullPointerException if the specified array is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length < size) {
			toHold = (E[]) Array.newInstance(array[0].getClass(), this.size);
		}
		
		System.arraycopy(array, 0, toHold, 0, size);
		
		return toHold;
	}
	
	/**
	 * Returns an array containing all elements of this list in proper sequence.
	 * 
	 * @return An array containing all elements of this list in proper sequence
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		Object[] toHold = (E[]) new Object[this.size];
		
		System.arraycopy(array, 0, toHold, 0, size);
		
		return toHold;
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayBasedIterator();
	}
	
	/**
	 * Private iterator class for iterating over the elements in the list.
	 */
	private class ArrayBasedIterator implements Iterator<E> {

		private int pos;
		private E[] copy;
		
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator() {
			copy = (E[]) new Object[size];
			System.arraycopy(array, 0, copy, 0, size);
		}
		
		/**
		 * Returns true if the iteration has more elements.
		 * 
		 * @return true if the iterator has more elements
		 */
		@Override
		public boolean hasNext() {
			return pos < size;
		}
		
		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public E next() throws NoSuchElementException {
			if(pos >= size) {
				throw new NoSuchElementException();
			}
			
			E toReturn = copy[pos++];
			
			return toReturn;
		}
		
	}
}
