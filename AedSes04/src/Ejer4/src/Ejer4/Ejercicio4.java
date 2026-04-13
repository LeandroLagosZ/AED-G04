package Ejer4;

import java.util.Scanner;

public class Ejercicio4 {

    public static boolean resolverLaberinto(int[][] laberinto, int[][] solucion) {
        return backtracking(laberinto, 0, 0, solucion);
    }

    private static boolean backtracking(int[][] laberinto, int x, int y, int[][] solucion) {
        int n = laberinto.length;
        int m = laberinto[0].length;

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (laberinto[x][y] == 1 || solucion[x][y] == 1) {
            return false;
        }

        solucion[x][y] = 1;

        if (x == n - 1 && y == m - 1) {
            return true;
        }

        if (backtracking(laberinto, x - 1, y, solucion)) {
            return true;
        }

        if (backtracking(laberinto, x + 1, y, solucion)) {
            return true;
        }

        if (backtracking(laberinto, x, y - 1, solucion)) {
            return true;
        }

        if (backtracking(laberinto, x, y + 1, solucion)) {
            return true;
        }

        solucion[x][y] = 0;
        return false;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        int[][] laberinto = new int[filas][columnas];
        int[][] solucion = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                laberinto[i][j] = sc.nextInt();
            }
        }

        boolean existeCamino = resolverLaberinto(laberinto, solucion);

        System.out.println(existeCamino);

        if (existeCamino) {
            imprimirMatriz(solucion);
        }

        sc.close();
    }
}