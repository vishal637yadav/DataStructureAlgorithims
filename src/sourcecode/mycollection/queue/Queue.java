package sourcecode.mycollection.queue;

/**
 * Queue support FIFO (First In First Out)
 */
public interface Queue<E> {

    /**
     * Inserts the specified element into the Queue at the Tail Position
     * @param data the element to add
     */
    void enQueue(E data);

    /**
     * Delete/Remove the element from the head position of the Queue
     * @return element data (E) that is going to be removed.
     * @return null, if Queue isEmpty (size=0)
    */
    E deQueue();

    /**
     * Check the emptiness of the  Queue empty(size=0)
     * @return true,  if Queue is empty (not contains any element(size == 0))
     * @return false, if Queue contains at-least one element(size >0).
     */
    boolean isEmpty();

}
