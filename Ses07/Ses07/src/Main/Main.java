package Main;
import bstreeInterface.*;
import bstreelinklistinterfgeneric.*;
import Exceptions.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBST<Integer> bst = new LinkedBST<>();
        try {
            int[] valores = {8, 3, 10, 1, 6, 14, 4, 7, 13};
            for (int val : valores) {
                bst.insert(val);
            }
            System.out.print("In-Orden de árbol: ");
            bst.inOrder();
        } catch (ItemDuplicated e) {
            System.out.println("Error de inserción: " + e.getMessage());
        }

        System.out.println("\nPrueba de conteos:");
        System.out.println("Total de nodos en el árbol: " + bst.countAllNodes());
        System.out.println("Nodos no-hojas en el árbol: " + bst.countNodes());

        System.out.println("\nPrueba de alturas:");
        System.out.println("Altura del subárbol desde el nodo 6: " + bst.height(6));

        System.out.println("\nPrueba de amplitud:");
        System.out.println("Amplitud en el nivel 2: " + bst.amplitude(2));
        System.out.println("Amplitud en el nivel 4 (No existen nodos aquí): " + bst.amplitude(4));

        System.out.println("\nPrueba de destrucción:");
        try {
            bst.destroyNodes();
            System.out.println("Método destroyNodes ejecutado.");
            System.out.println("¿El árbol está vacío ahora?: " + bst.isEmpty());
            System.out.println("Total de nodos tras la destrucción: " + bst.countAllNodes());
            
            System.out.println("Intentando destruir el árbol vacío");
            bst.destroyNodes();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
	}

}
