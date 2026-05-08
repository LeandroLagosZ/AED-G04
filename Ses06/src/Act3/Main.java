package Act3;

import Act1.ExceptionIsEmpty;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();
		pq.enqueue("A", 2);
        pq.enqueue("B", 5);
        pq.enqueue("C", 1);
        pq.enqueue("D", 4);

        System.out.println("Cola: " + pq);

        try {
            System.out.println("Front: " + pq.front());

            System.out.println("Back: " + pq.back());

            System.out.println("Dequeue: " + pq.dequeue());

            System.out.println("Cola después: " + pq);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
	}

}