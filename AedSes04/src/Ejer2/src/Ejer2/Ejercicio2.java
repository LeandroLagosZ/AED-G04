package Ejer2;

import java.util.Scanner;

public class Ejercicio2 {

    public static int kthMayor(int[] arr, int k) {
        int indiceBuscado = arr.length - k;
        return quickSelect(arr, 0, arr.length - 1, indiceBuscado);
    }

    private static int quickSelect(int[] arr, int izquierda, int derecha, int k) {
        if (izquierda == derecha) {
            return arr[izquierda];
        }

        int pivote = particionar(arr, izquierda, derecha);

        if (pivote == k) {
            return arr[pivote];
        } else if (k < pivote) {
            return quickSelect(arr, izquierda, pivote - 1, k);
        } else {
            return quickSelect(arr, pivote + 1, derecha, k);
        }
    }

    private static int particionar(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                intercambiar(arr, i, j);
                i++;
            }
        }

        intercambiar(arr, i, derecha);
        return i;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(kthMayor(arr, k));

        sc.close();
    }
}
