package EJER_3;

public interface PriorityQueue<E> {
    void enqueue(E x, int priority);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    boolean isEmpty();
}