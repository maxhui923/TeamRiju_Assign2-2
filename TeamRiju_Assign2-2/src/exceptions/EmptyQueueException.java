package exceptions;

/**
 * EmptyQueueException class
 * 
 * @author Team-Riju
 * @version Nov 20 2023
 *
 */

/** 
 * Create EmptyQueueException to be raised when the queue's length is zero
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception{
	public EmptyQueueException() {
		super("EmptyQueueException");
	}
}
