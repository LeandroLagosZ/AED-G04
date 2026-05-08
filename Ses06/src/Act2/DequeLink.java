package Act2;

import Act1.ExceptionIsEmpty;

class DequeLink<E> implements Deque<E> {
	private Node<E> first;
	private Node<E> last;
	public DequeLink() {
		first = null;
		last = null;
	}
	public void addFirst(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
	}
	public void addLast(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
	}
	public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola enlazada vacía");
        }
        E data = first.data;
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return data;
    
	}
	public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola enlazada vacía");
        }
        E data = last.data;
        if (first == last) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return data;
	}
	
	public E getFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola enlazada vacía");
        }
        return first.data;
	}
	
	public E getLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola enlazada vacía");
        }
        return last.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public String toString() {
        String cadena = "Cola: ";
        Node<E> current = first;
        while (current != null) {
            cadena += current.data + " ";
            current = current.next;
        }
        return cadena;
	}
}