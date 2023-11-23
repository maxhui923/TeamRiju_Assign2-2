package arrayImplementation;

/**
* Represents a MyDLLNode.
* 
* @author Team-Riju
* 
* @version Nov 20, 2023
*/

public class MyDLLNode <E>{
	
	private E element;
	private MyDLLNode<E> prev, next;
	
	/**
	 * Initializes a MyDLLNode object.
	 */
	public MyDLLNode() {
		
	}
	
	/**
	 * Initializes a MyDLLNode object.
	 * 
	 * @param element the element to be stored
	 */
	public MyDLLNode(E element) {
		this.element = element;
	}
	
	/**
	 * Initializes a MyDLLNode object.
	 * 
	 * @param element the element to be stored
	 * @param prev the link to the previous node
	 * @param next the link to the next node
	 */
	public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * Gets the element
	 * 
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Sets the element
	 * 
	 * @param element the element to be stored
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Gets the previous node
	 * 
	 * @return the previous node
	 */
	public MyDLLNode<E> getPrev() {
		return prev;
	}

	/**
	 * Sets the previous node
	 * 
	 * @param prev the previous node
	 */
	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * Gets the next node
	 * 
	 * @return the next node
	 */
	public MyDLLNode<E> getNext() {
		return next;
	}

	/**
	 * Sets the next node
	 * 
	 * @param next the next node
	 */
	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}

}
