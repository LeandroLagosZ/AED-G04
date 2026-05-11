package EJER_4;

public class Main {
    public static void main(String[] args) {
        PriorityQueueHybrid<String, Integer> pq = new PriorityQueueHybrid<>(3);

        try {
            pq.enqueue("A", 2, 5);
            pq.enqueue("B", 2, 1);
            pq.enqueue("C", 1, 3);
            pq.enqueue("D", 2, 3);

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