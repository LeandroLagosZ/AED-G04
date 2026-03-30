import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnalizadorMinero {
    private ZonaMinera[][] matriz;
    private int filas;
    private int columnas;

    public AnalizadorMinero(String nombreArchivo) throws FileNotFoundException {
        cargarArchivo(nombreArchivo);
    }

    private void cargarArchivo(String nombreArchivo) throws FileNotFoundException {
        Scanner archivo = new Scanner(new File(nombreArchivo));

        filas = archivo.nextInt();
        columnas = archivo.nextInt();

        matriz = new ZonaMinera[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String mineral = archivo.next();
                double cantidad = archivo.nextDouble();
                double pureza = archivo.nextDouble();

                matriz[i][j] = new ZonaMinera(mineral, cantidad, pureza);
            }
        }

        archivo.close();
    }

    public void analizarRegionMasValiosa(int k) {
        if (k <= 0 || k > filas || k > columnas) {
            System.out.println("El valor de k no es válido.");
            return;
        }

        double mayorValor = -1;
        int mejorFila = 0;
        int mejorColumna = 0;

        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= columnas - k; j++) {
                double suma = calcularValorRegion(i, j, k);

                if (suma > mayorValor) {
                    mayorValor = suma;
                    mejorFila = i;
                    mejorColumna = j;
                }
            }
        }

        System.out.println("Región más valiosa encontrada:");
        System.out.println("Posición inicial: (" + mejorFila + "," + mejorColumna + ")");
        System.out.println("Tamaño de la región: " + k + " x " + k);
        System.out.println();
        System.out.println("Zonas analizadas:");

        for (int i = mejorFila; i < mejorFila + k; i++) {
            for (int j = mejorColumna; j < mejorColumna + k; j++) {
                System.out.println(matriz[i][j]);
            }
        }

        System.out.println();
        System.out.println("Valor total estimado: " + mayorValor);
        System.out.println();
        System.out.println("Mineral predominante en la región: " + obtenerMineralPredominante(mejorFila, mejorColumna, k));
    }

    private double calcularValorRegion(int filaInicio, int columnaInicio, int k) {
        double suma = 0;

        for (int i = filaInicio; i < filaInicio + k; i++) {
            for (int j = columnaInicio; j < columnaInicio + k; j++) {
                suma += matriz[i][j].calcularValorEconomico();
            }
        }

        return suma;
    }

    private String obtenerMineralPredominante(int filaInicio, int columnaInicio, int k) {
        Map<String, Integer> contador = new HashMap<>();

        for (int i = filaInicio; i < filaInicio + k; i++) {
            for (int j = columnaInicio; j < columnaInicio + k; j++) {
                String mineral = matriz[i][j].getMineral();

                if (contador.containsKey(mineral)) {
                    contador.put(mineral, contador.get(mineral) + 1);
                } else {
                    contador.put(mineral, 1);
                }
            }
        }

        String predominante = "";
        int mayorFrecuencia = 0;

        for (String mineral : contador.keySet()) {
            if (contador.get(mineral) > mayorFrecuencia) {
                mayorFrecuencia = contador.get(mineral);
                predominante = mineral;
            }
        }

        return predominante;
    }
}