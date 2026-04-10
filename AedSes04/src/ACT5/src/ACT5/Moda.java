package ACT5;

import java.util.Arrays;

public class Actividad05Moda {

    public static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end) return 0;

        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele) {
                suma++;
            }
        }
        return suma;
    }

    public static int moda1(int[] array) {
        int first = 0;
        int end = array.length - 1;

        if (array.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        if (first == end) {
            return array[first];
        }

        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda);

        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, first, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }

        return moda;
    }

    public static int modaDivideVenceras(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }
        return modaDyV(array, 0, array.length - 1);
    }

    private static int modaDyV(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }

        int mid = (left + right) / 2;

        int modaIzq = modaDyV(array, left, mid);
        int modaDer = modaDyV(array, mid + 1, right);

        int frecIzq = contarEnRango(array, left, right, modaIzq);
        int frecDer = contarEnRango(array, left, right, modaDer);

        if (frecIzq >= frecDer) {
            return modaIzq;
        } else {
            return modaDer;
        }
    }

    private static int contarEnRango(int[] array, int left, int right, int valor) {
        int contador = 0;
        for (int i = left; i <= right; i++) {
            if (array[i] == valor) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] arreglo = {4, 2, 4, 3, 2, 4, 1, 4, 3, 2};

        System.out.println("Arreglo: " + Arrays.toString(arreglo));
        System.out.println("Moda por frecuencia: " + moda1(arreglo));
        System.out.println("Moda por divide y vencerás: " + modaDivideVenceras(arreglo));
    }
}