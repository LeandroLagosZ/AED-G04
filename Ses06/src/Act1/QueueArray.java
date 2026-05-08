package Act1;

class QueueArray<E> implements Queue<E> {
	private E[] array;
	private int front;
	private int rear;
	private int size;
	public QueueArray(int n) {
		array = (E[]) new Object[n];
		front = 0;
		rear = -1;
		size = 0;
	}
	public void enqueue(E x) {
	    if (isFull()) {
	        throw new RuntimeException("Arreglo lleno");
	    }
	    rear = (rear + 1) % array.length;
	    array[rear] = x;
	    size+=1;
	}
	public E dequeue() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty("Arreglo vacío");
	    }
	    E temp = array[front];
	    front = (front + 1) % array.length;
	    size-=1;
	    return temp;
	}
	public E front() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty("Arreglo vacío");
	    }
	    return array[front];
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == array.length;
	}
	public String toString() {
	    String cadena="Cola: ";
	    int i = front;
	    for (int count = 0; count < size; count++) {
	    	cadena+=array[i] +" ";
	        i = (i + 1) % array.length;
	    }
	    return cadena;
	}
}