package arrayImplementation;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.*;

/**
 * Utility class for a stack implemented using an array list.
 * 
 * This class implements the StackADT interface and provides methods for
 * manipulating a stack, including push, pop, peek, and iterator functionality.
 * 
 * @param <E> The type of element stored in the stack
 * 
 * @version Nov 20, 2023
 */
@SuppressWarnings("serial")
public class MyStack<E> implements StackADT<E> {

	private MyArrayList<E> list;
	
	public MyStack() {
		list = new MyArrayList<>();
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param toAdd The item to be pushed onto the top of the stack
	 * @throws NullPointerException When attempting to add a null element to the
	 *                              stack
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}

		list.add(0, toAdd);
	}

	/**
	 * Removes the object at the top of this stack and returns that object.
	 * 
	 * @return The item popped off the top of the stack
	 * @throws EmptyStackException If there are no items in the stack
	 */
	@Override
	public E pop() throws EmptyStackException {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}

		return list.remove(0);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return The object at the top of this stack.
	 * @throws EmptyStackException If the stack is empty
	 */
	@Override
	public E peek() throws EmptyStackException {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}

		return list.get(0);
	}

	/**
	 * Clears all the items from this stack.
	 */
	@Override
	public void clear() {
		list.clear();
	}

	/**
	 * Returns true if this stack contains no items.
	 * 
	 * @return true if this stack contains no items
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 *         sequence
	 */
	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array.
	 * 
	 * @param holder The array into which the elements of this stack are to be
	 *               stored, if it is big enough; otherwise, a new array of the same
	 *               runtime type is allocated for this purpose.
	 * @return An array containing the elements of this stack
	 * @throws NullPointerException If the specified array is null
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
			throw new NullPointerException();
		}

		return list.toArray(holder);
	}

	/**
	 * Returns true if this stack contains the specified element.
	 * 
	 * @param toFind The element whose presence in this stack is to be tested
	 * @return true if this stack contains the specified element
	 * @throws NullPointerException If the specified element is null and this stack
	 *                              does not support null elements
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}

		return list.contains(toFind);
	}

	/**
	 * Returns the 1-based position where an object is on this stack.
	 * 
	 * @param toFind The desired object
	 * @return The 1-based position from the top of the stack where the object is
	 *         located; the return value -1 indicates that the object is not on the
	 *         stack
	 */
	@Override
	public int search(E toFind) {
		int pos = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(toFind)) {
				pos = i + 1;
				break;
			}
		}

		return pos;
	}

	/**
	 * Used to compare two Stack ADTs. To be equal, two stacks must contain equal
	 * items appearing in the same order.
	 * 
	 * @param that The Stack ADT to be compared to this stack
	 * @return true if the stacks are equal
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		if (list.size() != that.size()) {
			return false;
		}

		Iterator<E> thisIterator = this.iterator();
		Iterator<E> thatIterator = that.iterator();

		while (thisIterator.hasNext()) {
			E thisE = thisIterator.next();
			E thatE = thatIterator.next();

			if (!thisE.equals(thatE)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the depth of the current stack as an integer value.
	 * 
	 * @return The current size of the stack as an integer
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Returns an iterator over the elements in this stack in proper sequence.
	 * 
	 * @return An iterator over the elements in this stack in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	/**
	 * Private inner class representing an iterator for the stack.
	 */
	private class StackIterator implements Iterator<E> {

		private Iterator<E> iterator;

		/**
		 * Constructs a new StackIterator.
		 */
		public StackIterator() {
			iterator = list.iterator();
		}

		/**
		 * Returns true if the iteration has more elements.
		 * 
		 * @return true if the iterator has more elements
		 */
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration
		 * @throws NoSuchElementException If the iteration has no more elements
		 */
		@Override
		public E next() throws NoSuchElementException {
			return iterator.next();
		}
	}

}
