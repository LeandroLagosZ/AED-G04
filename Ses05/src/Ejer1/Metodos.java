package Ejer1;

public class Metodos {
	
	public static <T> boolean buscarElemento(ListLinked<T> lista, T valor){
		//Primero, obtenemos el primer valor de la lista enlazada
		Node<T> actual = lista.first;
		
		//Ahora vamos a recorrer la lista
		while (actual != null) {
			
			//Utilizamos equals porque son tipos de datos NO primitivos
			if (actual.value.equals(valor)) {
				
				//Si lo encuentra devuelve True
				return true;
			}
			
			//Recorremos al siguiente
			actual=actual.next;
		}
		
		//Recorre toda la lista, si no lo encuentra devuelve Flase
		return false;
	}
	
	public static <T> ListLinked<T> invertirLista(ListLinked<T> lista) {
		 //Pensemos 2 soluciones, empezar desde adelante o desde atrás
		Node<T> auxiliar = lista.first;
		ListLinked<T> invertida= new ListLinked();
		while (auxiliar!=null) {
			invertida.insertFirst(auxiliar.value);
			auxiliar=auxiliar.next;
		}
		return invertida;
	}
	
	public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
		if (head==null) {
			return new Node<>(valor);
		}
		Node<T> cabeza=head;
		while (head.next!=null) {
			 head=head.next;
		 }
		 
		 head.next=new Node<>(valor);
		 
		 return cabeza;
	}
	
	public static <T> int contarNodos(Node<T> head) {
		 int i=0;

		 Node<T> recorre=head;
		 while (recorre!=null) {
			 i+=1;
			 recorre=recorre.next;
		 }
		 return i;
	}
	
	public static <T> boolean sonIguales(ListLinked<T> lista1, ListLinked<T> lista2) {
		//Suponiendo que se verificó que ambos tienen el mismo tamaño
		Node<T> recorre1=lista1.first;
		Node<T> recorre2=lista2.first;
		while (recorre1!=null && recorre2!=null) {
			if(!recorre1.value.equals(recorre2.value)) {
				return false;
			}
			recorre1=recorre1.next;
			recorre2=recorre2.next;
		}
		
		return true;
	}
	public static <T> ListLinked<T> concatenarListas(ListLinked<T> lista1, ListLinked<T> lista2) {
		ListLinked<T> listaconcat=new ListLinked<>();
		//Primero la lsita1, luego la lista 2
		Node<T> recorre=lista1.first;
		
		while (recorre!=null) {
			listaconcat.insertLast(recorre.value);
			recorre=recorre.next;
		}
		recorre=lista2.first;
		while (recorre!=null) {
			listaconcat.insertLast(recorre.value);
			recorre=recorre.next;
		}
		
		return listaconcat;
	}

}
