package EJER_4;

public class PriorityQueueHybrid<E, S extends Comparable<S>> {

    private class Entry {
        E data;
        S secondary;

        Entry(E data, S secondary) {
            this.data = data;
            this.secondary = secondary;
        }

        public String toString() {
            return "(" + data + "," + secondary + ")";
        }
    }

    private Node<Entry>[] queues;
    private int levels;

    public PriorityQueueHybrid(int levels) {
        this.levels = levels;
        queues = new Node[levels];

        for (int i = 0; i < levels; i++) {
            queues[i] = null;
        }
    }

    public void enqueue(E x, int priority, S secondary) {
        if (priority < 0 || priority >= levels) {
            throw new RuntimeException("Prioridad inválida");
        }

        Entry nuevoEntry = new Entry(x, secondary);
        Node<Entry> nuevo = new Node<>(nuevoEntry);

        if (queues[priority] == null ||
            secondary.compareTo(queues[priority].getData().secondary) < 0) {

            nuevo.setNext(queues[priority]);
            queues[priority] = nuevo;
            return;
        }

        Node<Entry> actual = queues[priority];

        while (actual.getNext() != null &&
               secondary.compareTo(actual.getNext().getData().secondary) >= 0) {
            actual = actual.getNext();
        }

        nuevo.setNext(actual.getNext());
        actual.setNext(nuevo);
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue hybrid is empty");
        }

        for (int i = levels - 1; i >= 0; i--) {
            if (queues[i] != null) {
                E aux = queues[i].getData().data;
                queues[i] = queues[i].getNext();
                return aux;
            }
        }

        throw new ExceptionIsEmpty("Priority queue hybrid is empty");
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Priority queue hybrid is empty");
        }

        for (int i = levels - 1; i >= 0; i--) {
            if (queues[i] != null) {
                return queues[i].getData().data;
            }
        }

        throw new ExceptionIsEmpty("Priority queue hybrid is empty");
    }

    public boolean isEmpty() {
        for (int i = 0; i < levels; i++) {
            if (queues[i] != null) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        String cadena = "";

        for (int i = levels - 1; i >= 0; i--) {
            cadena += "Nivel " + i + ": ";

            Node<Entry> actual = queues[i];

            if (actual == null) {
                cadena += "vacío";
            }

            while (actual != null) {
                cadena += actual.getData();

                if (actual.getNext() != null) {
                    cadena += " -> ";
                }

                actual = actual.getNext();
            }

            cadena += "\n";
        }

        return cadena;
    }
}