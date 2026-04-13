package Ejer1;

import java.util.Scanner;

public class Ejercicio1 {

    public static boolean existeSubconjunto(int[] arr, int objetivo) {
        return backtracking(arr, 0, objetivo);
    }

    private static boolean backtracking(int[] arr, int indice, int objetivo) {
        if (indice == arr.length) {
            return objetivo == 0;
        }

        int actual = arr[indice];

        if (actual % 3 == 0) {
            return backtracking(arr, indice + 1, objetivo - actual);
        }

        boolean puedeElegirse = true;

        if (actual % 2 == 0 && indice < arr.length - 1 && arr[indice + 1] % 2 == 0) {
            puedeElegirse = false;
        }

        if (puedeElegirse && backtracking(arr, indice + 1, objetivo - actual)) {
            return true;
        }

        return backtracking(arr, indice + 1, objetivo);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int objetivo = sc.nextInt();

        System.out.println(existeSubconjunto(arr, objetivo));

        sc.close();
    }
}
