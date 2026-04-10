package Act4;

public class Merge {
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) { 
			return; 
		}

		int mitad = arr.length / 2; 
		int[] izq = new int[mitad]; 
		int[] der = new int[arr.length - mitad]; 

		System.arraycopy(arr, 0, izq, 0, mitad); 
		System.arraycopy(arr, mitad, der, 0, arr.length - mitad);

		mergeSort(izq);
		mergeSort(der);
		fusionar(arr, izq, der); 
	}

	private static void fusionar(int[] arr, int[] izq, int[] der) {
		int i = 0;
		int j = 0; 
		int k = 0; 

		while (i < izq.length && j < der.length) {
			if (izq[i] <= der[j]) { 
				arr[k] = izq[i]; 
				i++; 
			} else {
				arr[k] = der[j]; 
				j++; 
			}
			k++;
		}

		while (i < izq.length) { 
			arr[k] = izq[i]; 
			i++; 
			k++; 
		}

		while (j < der.length) { 
			arr[k] = der[j];
			j++; 
			k++; 
		}
	}
}
