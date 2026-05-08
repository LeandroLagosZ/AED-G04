package Act2;

import Act1.ExceptionIsEmpty;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeLink<String> deque = new DequeLink<>();

		try {
			System.out.println("Insertando por ambos extremos");
			deque.addLast("Leandro");
			deque.addFirst("Miranda");
			deque.addLast("Fran");
			System.out.println(deque); 

			System.out.println("\nObteniendo extremos");
			System.out.println("Primero: " + deque.getFirst());
			System.out.println("Último: " + deque.getLast());

			System.out.println("\nRemoviendo por ambos extremos");
			System.out.println("Removido del inicio: " + deque.removeFirst());
			System.out.println("Removido del final: " + deque.removeLast());
			System.out.println("Estado final: " + deque);

		} catch (ExceptionIsEmpty e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
