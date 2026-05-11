package EJER_3;

public class PriorityQueueMultiple<E> implements PriorityQueue<E> {
    private QueueLink<E>[] queues;
    private int levels;

    public PriorityQueueMultiple(int levels) {
        this.levels = levels;
        queues = new QueueLink[levels];

        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, int priority) {
        if (priority < 0 || priority >= levels) {
            throw new RuntimeException("Prioridad inválida");
        }

        queues[priority].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue is empty");
        }

        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }

        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue is empty");
        }

        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].front();
            }
        }

        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public boolean isEmpty() {
        for (int i = 0; i < levels; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        String cadena = "";

        for (int i = levels - 1; i >= 0; i--) {
            cadena += "Prioridad " + i + ": " + queues[i].toString() + "\n";
        }

        return cadena;
    }
}