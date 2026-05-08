package Act1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueArray<Integer> q = new QueueArray<>(4);

		try {
			System.out.println("Probando Enqueue");
			q.enqueue(10);
			q.enqueue(20);
			q.enqueue(30);
			q.enqueue(40);
			System.out.println(q); 

			System.out.println("\nProbando Dequeue y Frente");
			System.out.println("Ejecutar dequeue: " + q.dequeue());
			System.out.println("Nuevo front: " + q.front());
			System.out.println(q);

			System.out.println("\nProbando Circularidad");
			q.enqueue(50); 
			System.out.println(q);
			System.out.println("50 se encuentra antes que 20 en el arreglo, en la cola se encuentra después");

		} catch (ExceptionIsEmpty e) {
			System.out.println("Error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
