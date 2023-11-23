package arrayImplementation;

import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 * Utility class implementing a queue.
 *
 * This class implements the QueueADT interface and provides methods for
 * manipulating a queue, including enqueue, dequeue, peek, and iterator
 * functionality.
 *
 * @param <E> The type of element stored in the queue.
 *
 * @version Nov 20, 2023
 */
@SuppressWarnings("serial")
public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;
    
    public MyQueue() {
		list = new MyDLL<>();
	}

    /**
     * Adds the specified element to the end of the queue.
     *
     * @param toAdd The item to be added to the queue.
     * @throws NullPointerException If the provided object is null.
     */
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot enqueue null element.");
        }
        list.add(toAdd);
    }

    /**
     * Removes and returns the first element from the queue.
     *
     * @return The first item in the queue.
     * @throws EmptyQueueException If the queue is empty.
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.remove(0);
    }

    /**
     * Retrieves, but does not remove, the first element in the queue.
     *
     * @return The first item in the queue.
     * @throws EmptyQueueException If the queue is empty.
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.get(0);
    }

    /**
     * Removes all items from the queue.
     */
    @Override
    public void dequeueAll() {
        list.clear();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Compares two QueueADT instances for equality.
     *
     * Two queues are equal if they contain equal items appearing in the same order.
     *
     * @param that The QueueADT to be compared to this queue.
     * @return true if the queues are equal.
     */
    @Override
    public boolean equals(QueueADT<E> that) {
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
     * Returns an array containing all elements in proper sequence.
     *
     * @return An array containing all elements in proper sequence.
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Returns an array containing all elements in proper sequence.
     *
     * The runtime type of the returned array is that of the specified array.
     *
     * @param holder The array into which the elements of this queue are to be stored,
     *               if it is big enough; otherwise, a new array of the same runtime
     *               type is allocated for this purpose.
     * @return An array containing the elements of this queue.
     * @throws NullPointerException If the specified array is null.
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Provided array is null.");
        }
        return list.toArray(holder);
    }

    /**
     * Checks if the queue is at capacity (optional for non-fixed length queue).
     *
     * @return true if the queue is at capacity.
     */
    @Override
    public boolean isFull() {
        return true; // Optional. This implementation assumes a non-fixed length queue.
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The size of the queue.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator over the elements in proper sequence.
     *
     * @return An iterator over the elements in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    /**
     * Iterator for the queue, providing sequential access to the elements.
     */
    private class QueueIterator implements Iterator<E> {

        private Iterator<E> iterator;

        /**
         * Constructs a QueueIterator.
         */
        public QueueIterator() {
            iterator = list.iterator();
        }

        /**
         * Checks if the iteration has more elements.
         *
         * @return true if the iterator has more elements.
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return The next element in the iteration.
         * @throws NoSuchElementException If the iteration has no more elements.
         */
        @Override
        public E next() throws NoSuchElementException {
            return iterator.next();
        }
    }
}
