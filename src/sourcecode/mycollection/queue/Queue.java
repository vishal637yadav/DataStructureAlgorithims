package sourcecode.mycollection.queue;

public interface Queue<E> {
    void enQueue(E data);
    /*return the deQueued element for the Queue.
    * if isQueue isEmpty() return null */
    E deQueue();
    boolean isEmpty();
}
