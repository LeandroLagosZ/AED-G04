package Ejer3;

import java.util.Scanner;

public class Ejercicio3 {

    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }

        for (int longitud = 2; longitud <= n; longitud++) {
            for (int i = 0; i <= n - longitud; i++) {
                int j = i + longitud - 1;
                C[i][j] = T[i][j];

                for (int k = i + 1; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                }
            }
        }

        return C;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                T[i][j] = sc.nextInt();
            }
        }

        int[][] C = calcularCostosMinimos(T);

        imprimirMatriz(C);

        int origen = sc.nextInt();
        int destino = sc.nextInt();

        System.out.println(C[origen][destino]);

        sc.close();
    }
}
