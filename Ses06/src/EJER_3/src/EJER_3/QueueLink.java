package EJER_3;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
        } else {
            last.setNext(nuevo);
            last = nuevo;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        E aux = first.getData();
        first = first.getNext();

        if (first == null) {
            last = null;
        }

        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty");
        }

        return first.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String cadena = "";
        Node<E> actual = first;

        while (actual != null) {
            cadena += actual.getData() + " ";
            actual = actual.getNext();
        }

        return cadena;
    }
}