package Main;
import bstreeInterface.*;
import bstreelinklistinterfgeneric.*;
import Exceptions.*;

public class MainEjer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBST<Integer> bst1 = new LinkedBST<>();
		LinkedBST<Integer> bst2 = new LinkedBST<>();

		try {
			int[] valores1 = {15, 8, 22, 5, 12, 18, 30};
			for (int val : valores1) {
				bst1.insert(val);
			}
			System.out.println("Árbol 1 creado con éxito.");

			int[] valores2 = {10, 5, 15};
			for (int val : valores2) {
				bst2.insert(val);
			}
			System.out.println("Árbol 2 creado con éxito.");

		} catch (ItemDuplicated e) {
			System.out.println("Error de inserción: " + e.getMessage());
		}

		System.out.println("\nDibujando");
		System.out.println("Dibujando Árbol 1");
		bst1.drawBST();

		System.out.println("\nDibujando Árbol 2");
		bst2.drawBST();

		System.out.println("\nCalculando area");
		try {
			System.out.println("Área del Árbol 1 (Hojas * Altura): " + bst1.areaBST());
			System.out.println("Área del Árbol 2 (Hojas * Altura): " + bst2.areaBST());
		} catch (ExceptionIsEmpty e) {
			System.out.println("Error al calcular área: " + e.getMessage());
		}

		System.out.println("\nVerificando si son iguales");
		boolean sonIguales = sameArea(bst1, bst2);
		System.out.println("¿El Árbol 1 y el Árbol 2 tienen la misma área?: " + sonIguales);

		boolean sonIgualesMismo = sameArea(bst1, bst1);
		System.out.println("¿El Árbol 1 tiene la misma área que sí mismo?: " + sonIgualesMismo);
	}
	
	public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> t1, LinkedBST<E> t2) {
		try {
			return t1.areaBST() == t2.areaBST();
		} catch (ExceptionIsEmpty e) {
			return false;
		}
	}

}
