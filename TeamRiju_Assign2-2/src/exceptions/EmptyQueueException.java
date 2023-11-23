package exceptions;

/**
 * EmptyQueueException class
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
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
