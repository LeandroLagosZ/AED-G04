package Ejer8;

public class NodeDoble<T> {
    public T value;
    public NodeDoble<T> next;
    public NodeDoble<T> prev;

    public NodeDoble(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}