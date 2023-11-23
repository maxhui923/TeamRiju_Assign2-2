package arrayImplementation;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * Utility class for implementing a doubly linked list.
 * 
 * This class implements the ListADT interface and provides
 * methods to manipulate a doubly linked list.
 * 
 * @param <E> The type of element stored in the list
 * 
 * @version Nov 20, 2023
 */
@SuppressWarnings("serial")
public class MyDLL <E> implements ListADT<E>{
	
    private MyDLLNode<E> head, tail;
	
	private int size = 0;
	
	/**
	 * Constructs an empty doubly linked list.
	 */
	public MyDLL() {
		this.head = this.tail = null;
	}

	/**
	 * Constructs a doubly linked list with the given head and tail nodes.
	 * 
	 * @param head The head node of the list
	 * @param tail The tail node of the list
	 */
	public MyDLL(MyDLLNode<E> head, MyDLLNode<E> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	/**
	 * Returns the current size of the list.
	 * 
	 * @return The current element count in the list
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
		head = tail = null;
		size = 0;
	}
	
	/**
	 * Inserts the specified element at the specified position in the list.
	 * Shifts the element currently at that position (if any) and any
	 * subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index The index at which the specified element is to be inserted
	 * @param toAdd The element to be inserted
	 * @return true if the element is added successfully
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {		
			if(index == 0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
			else if(index == size) {
				return add(toAdd);
			}
			else {
				MyDLLNode<E> curr = head;
				
				for(int i = 0; i < index; i++) {
					curr = curr.getNext();
				}
				
				curr.getPrev().setNext(newNode);
				newNode.setPrev(curr.getPrev());
				curr.setPrev(newNode);
				newNode.setNext(curr);
			}
		}
		
		size++;
		
		return true;
	}
	
	/**
	 * Appends the specified element to the end of the list.
	 * 
	 * @param toAdd Element to be appended to the list
	 * @return true if the element is appended successfully
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		
		if(!isEmpty()) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			head = tail = newNode;
		}
		
		size++;
		
		return true;
	}
	
	/**
	 * Appends all elements in the given list to the end of this list.
	 * 
	 * @param toAdd The list to be added to the end of this list
	 * @return true if the operation is successful
	 * @throws NullPointerException if the specified list is null
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode;
		
		int startIndex = 0;
		if(isEmpty()) {
			newNode = new MyDLLNode<>(toAdd.get(0));
			head = tail = newNode;
			
			size++;
			startIndex = 1;
		}
		
		for(int i = startIndex; i < toAdd.size(); i++) {
			newNode = new MyDLLNode<>(toAdd.get(i));
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			
			size++;
		}
		
		return true;
	}
	
	/**
	 * Returns the element at the specified position in the list.
	 * 
	 * @param index Index of the element to return
	 * @return The element at the specified position in the list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr.getElement();
	}
	
	/**
	 * Removes the element at the specified position in the list.
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
		
		E deleted = null;
		
		if(index == 0) {
			deleted = head.getElement();
			
			if(head == tail) {
				head = tail = null;
			}
			else {
				head.getNext().setPrev(null);
				head = head.getNext();
			}
		} else if(index == size() - 1) {
			deleted = tail.getElement();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> curr = head;
			
			for(int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			deleted = curr.getElement();
			
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
		}
		
		size--;
		
		return deleted;
	}

	/**
	 * Removes the first occurrence in this list of the specified element.
	 * 
	 * @param toRemove The element to be removed from the list
	 * @return The element which is being removed or null if the list does not contain the element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException();
		}
		
		if(isEmpty()) {
			return null;
		}
		
		E deleted = null;
		
		if(head.getElement().equals(toRemove)) {
			deleted = head.getElement();
			
			if(head == tail) {
				head = tail = null;
			}
			else {
				head.getNext().setPrev(null);
				head = head.getNext();
			}
		} else if(tail.getElement().equals(toRemove)) {
			deleted = tail.getElement();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> curr = head;
			
			for(int i = 0; i < size(); i++) {
				if(curr.getElement().equals(toRemove)) {
					deleted = curr.getElement();
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
					
					break;
				}
				curr = curr.getNext();
			}
		}
		
		if(deleted != null) {
			size--;
		}
		
		return deleted;
	}

	/**
	 * Replaces the element at the specified position in the list with the specified element.
	 * 
	 * @param index The index of the element to replace
	 * @param toChange Element to be stored at the specified position
	 * @return The element previously at the specified position.
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
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		
		E preValue = curr.getElement();
		curr.setElement(toChange);
		
		return preValue;
	}

	/**
	 * Checks if the list contains no elements.
	 * 
	 * @return true if the list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Checks if the list contains the specified element.
	 * 
	 * @param toFind The element whose presence in the list is to be tested
	 * @return true if the list contains the specified element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean result = false;
		
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < size(); i++) {
			if(curr.getElement().equals(toFind)) {
				result = true;
			}
			curr = curr.getNext(); 
		}
		
		return result;
	}
	
	/**
	 * Returns an array containing all elements in the list in proper sequence.
	 * 
	 * @param toHold The array into which the elements of the list are to be stored,
	 *               if it is big enough; otherwise, a new array of the same runtime type
	 *               is allocated for this purpose
	 * @return An array containing the elements of the list
	 * @throws NullPointerException if the specified array is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		
		if(toHold.length < size) {
			toHold = (E[]) Array.newInstance(head.getElement().getClass(), this.size);
		}
		
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size(); i++) {
			toHold[i] = curr.getElement();
			curr = curr.getNext();
		}
		return toHold;
	}

	/**
	 * Returns an array containing all elements in the list in proper sequence.
	 * 
	 * @return An array containing all elements in the list in proper sequence
	 */
	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[size()];
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size(); i++) {
			newArray[i] = curr.getElement();
			curr = curr.getNext();
		}
		return newArray;
	}
	
	/**
	 * Returns an iterator over the elements in the list, in proper sequence.
	 * 
	 * @return An iterator over the elements in the list, in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	/**
	 * Private inner class representing an iterator for the doubly linked list.
	 */
	private class LinkedListIterator implements Iterator<E> {

		private MyDLLNode<E> pos;
		
		/**
		 * Constructs a new LinkedListIterator.
		 */
		public LinkedListIterator() {
			pos = null;
		}
		
		/**
		 * Returns true if the iteration has more elements.
		 * 
		 * @return true if the iterator has more elements
		 */
		@Override
		public boolean hasNext() {			
			if(pos == null) {
				return head != null;
			}
			else {
				return pos.getNext() != null;				
			}
			
		}
		
		/**
		 * Returns the next element in the iteration.
		 * 
		 * @return The next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException();
			
			if(pos == null) {
				pos = head;
			}
			else {
				pos = pos.getNext();				
			}
			
	        E element = pos.getElement();
	        
	        return element;
		}
		
	}

}
