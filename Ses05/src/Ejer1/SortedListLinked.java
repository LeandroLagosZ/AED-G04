package Ejer1;

public class SortedListLinked<T extends Comparable<T>> extends ListLinked<T> {
    
	public void insertOrden(T x) {
        Node<T> nuevo = new Node<>(x);
        if (first == null || x.compareTo(first.value) < 0) {
            nuevo.next = first;
            first = nuevo;
        } else {
            Node<T> aux = first;
            while (aux.next != null && x.compareTo(aux.next.value) > 0) {
                aux = aux.next;
            }
            nuevo.next = aux.next;
            aux.next = nuevo;
        }
    }
}