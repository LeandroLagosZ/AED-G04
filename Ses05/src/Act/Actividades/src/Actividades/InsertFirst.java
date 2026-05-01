package Actividades;

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