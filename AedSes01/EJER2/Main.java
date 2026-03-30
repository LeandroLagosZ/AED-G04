import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Ingrese el nombre del archivo: ");
            String nombreArchivo = entrada.nextLine();

            System.out.print("Ingrese el tamaño de la subregión k: ");
            int k = entrada.nextInt();

            AnalizadorMinero analizador = new AnalizadorMinero(nombreArchivo);
            System.out.println();
            analizador.analizarRegionMasValiosa(k);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }

        entrada.close();
    }
}