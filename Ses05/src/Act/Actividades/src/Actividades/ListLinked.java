package Actividades;

public class ListLinked<T> {
    private Node<T> first;

    public ListLinked() {
        this.first = null;
    }

    public boolean isEmptyList() {
        return first == null;
    }

    public void insertFirst(T x) {
        Node<T> nuevo = new Node<>(x);
        nuevo.next = first;
        first = nuevo;
    }

    public void insertLast(T x) {
        Node<T> nuevo = new Node<>(x);

        if (isEmptyList()) {
            first = nuevo;
        } else {
            Node<T> actual = first;

            while (actual.next != null) {
                actual = actual.next;
            }

            actual.next = nuevo;
        }
    }

    public boolean removeNode(T x) {
        if (isEmptyList()) {
            return false;
        }

        if (first.value.equals(x)) {
            first = first.next;
            return true;
        }

        Node<T> actual = first;

        while (actual.next != null) {
            if (actual.next.value.equals(x)) {
                actual.next = actual.next.next;
                return true;
            }

            actual = actual.next;
        }

        return false;
    }

    public boolean search(T x) {
        Node<T> actual = first;

        while (actual != null) {
            if (actual.value.equals(x)) {
                return true;
            }

            actual = actual.next;
        }

        return false;
    }

    public int length() {
        int contador = 0;
        Node<T> actual = first;

        while (actual != null) {
            contador++;
            actual = actual.next;
        }

        return contador;
    }

    public void print() {
        Node<T> actual = first;

        while (actual != null) {
            System.out.println(actual.value);
            actual = actual.next;
        }
    }

    public void reverse() {
        Node<T> anterior = null;
        Node<T> actual = first;
        Node<T> siguiente;

        while (actual != null) {
            siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }

        first = anterior;
    }

    public Node<T> getFirst() {
        return first;
    }
}