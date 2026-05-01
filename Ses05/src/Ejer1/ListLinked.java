package Ejer1;

public class ListLinked<T> {
    public Node<T> first;

    public ListLinked() {
        this.first = null;
    }

    public boolean isEmptyList() {
        return first == null;
    }

    public void insertFirst(T x) {
        Node<T> newNode = new Node<>(x);
        newNode.next = first;
        first = newNode;
    }
    
    public void insertLast(T x) {
    	if (first==null) {
    		insertFirst(x);
    		return;
    	}
    	
    	Node <T> nuevo=new Node<>(x);
    	Node<T> recorre= first;
    	while (recorre.next!=null) {
    		recorre=recorre.next;
    	}
    	
    	recorre.next=nuevo;
    	
    }
    
    @Override
    public String toString() {
    	if (first==null) {
    		return "Lista vacía";
    	}
    	
    	String listaPlana="Lista:";
    	Node<T> actual= first;
    	while (actual!=null) {
    		listaPlana+="  "+actual.value;
    		actual=actual.next;
    	}
    	return listaPlana;
    }
}