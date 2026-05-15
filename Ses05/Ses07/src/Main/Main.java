package Main;
import bstreeInterface.*;
import bstreelinklistinterfgeneric.*;
import Exceptions.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBST<Integer> bst = new LinkedBST<>();

        System.out.println("Inserción");
        try {
            int[] valores = {8, 3, 10, 1, 6, 14, 4, 7, 13};
            for (int val : valores) {
                bst.insert(val);
                System.out.println("Insertado: " + val);
            }
            
            System.out.println("\nÁrbol (toString): " + bst.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Error de inserción: " + e.getMessage());
        }

        System.out.println("\nRecorridos:");
        System.out.print("In-Orden: ");
        bst.inOrder();
        
        System.out.print("Pre-Orden: ");
        bst.preOrder();
        
        System.out.print("Post-Orden: ");
        bst.postOrder();

        System.out.println("\nBuscando elemento:");
        try {
            System.out.println("Buscando 13: " + bst.search(13));
            
            System.out.println("Buscando 20: ");
            System.out.println(bst.search(20)); 
        } catch (ItemNotFound e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nMínimo y máximo:");
        try {
            System.out.println("Mínimo: " + bst.min());
            System.out.println("Máximo: " + bst.max());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nEliminando:");
        try {
            System.out.println("Eliminando nodo con valor 4");
            bst.delete(4);
            System.out.println("Árbol actual: " + bst.toString());

            System.out.println("Eliminando nodo con valor 14");
            bst.delete(14);
            System.out.println("Árbol actual: " + bst.toString());

            System.out.println("Eliminando nodo con valor 8.");
            bst.delete(8);
            System.out.println("Árbol actual: " + bst.toString());
            
            System.out.print("Nuevo In-Orden: ");
            bst.inOrder();
            
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
	}

}
