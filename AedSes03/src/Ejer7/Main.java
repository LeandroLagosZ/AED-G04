package Ejer7;

public class Main {

	public static void main(String[] args) {
		int[] datos = {38, 27, 43, 3, 9, 82, 10};

		System.out.println("Arreglo original:");
		imprimirArreglo(datos);

		mergeSort(datos);

		System.out.println("Arreglo ordenado:");
		imprimirArreglo(datos);
	}
	public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {   //O(1)
            return;                            //O(1)
        }
        int mitad = arr.length / 2;           //O(1)
        
        int[] izq = new int[mitad];                //O(1) 
        int[] der = new int[arr.length - mitad];  //O(1)
        
           //copiar desde arr[0] a izq[0] mitad elementos, reduce código de for
        System.arraycopy(arr, 0, izq, 0, mitad);                  //O(n)
        System.arraycopy(arr, mitad, der, 0, arr.length - mitad); //O(n)

        //2*T(n/2) = O(log n)
        mergeSort(izq); 
        mergeSort(der); 

        fusionar(arr, izq, der);     //O(n)
    }
	
	private static void fusionar(int[] arr, int[] izq, int[] der) {
        int i = 0;   //O(1)
        int j = 0;  //O(1)
        int k = 0; //O(1)
        
        //En el peor caso O(n)
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {             //O(1)
                arr[k] = izq[i];               //O(1)
                i++;                          //O(1)
            } else {
                arr[k] = der[j];            //O(1)
                j++;                       //O(1)
            }
            k++;                         //O(1)
        }

        while (i < izq.length) {          //O(n)
            arr[k] = izq[i];             //O(1)
            i++;                        //O(1)
            k++;                       //O(1)
        }

        
        while (j < der.length) {      //O(n)
            arr[k] = der[j];         //O(1)
            j++;                    //O(1)
            k++;                   //O(1)
        }
    }
	
	private static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
