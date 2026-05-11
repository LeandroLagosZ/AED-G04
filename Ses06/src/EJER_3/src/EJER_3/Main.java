package EJER_3;

public class Main {
    public static void main(String[] args) {
        PriorityQueueMultiple<String> pq = new PriorityQueueMultiple<>(3);

        try {
            pq.enqueue("A", 0);
            pq.enqueue("B", 2);
            pq.enqueue("C", 1);
            pq.enqueue("D", 2);

            System.out.println(pq);

            System.out.println("Front: " + pq.front());

            System.out.println("Dequeue: " + pq.dequeue());
            System.out.println("Dequeue: " + pq.dequeue());
            System.out.println("Dequeue: " + pq.dequeue());
            System.out.println("Dequeue: " + pq.dequeue());

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
