package Act3;

import Act1.ExceptionIsEmpty;

class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode entry = new EntryNode(x, pr);
        Node<EntryNode> newNode = new Node<>(entry);

        if (isEmpty()) {
            first = last = newNode;
            return;
        }

        if (pr.compareTo(first.getData().priority) > 0) {
            newNode.setNext(first);
            first = newNode;
            return;
        }

        Node<EntryNode> current = first;

        while (current.getNext() != null &&
               pr.compareTo(current.getNext().getData().priority) <= 0) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);

        if (newNode.getNext() == null) {
            last = newNode;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue is empty");

        E aux = this.first.getData().data;
        this.first = this.first.getNext();

        if (this.first == null)
            this.last = null;

        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue is empty");
        return first.getData().data;
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue is empty");
        return last.getData().data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String result = "";
        Node<EntryNode> current = first;

        while (current != null) {
            result += "(" + current.getData().data + ", " +
                      current.getData().priority + ") ";
            current = current.getNext();
        }

        return result.trim();
    }
}