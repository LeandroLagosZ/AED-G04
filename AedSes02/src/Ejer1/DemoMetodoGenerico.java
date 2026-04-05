package Ejer1;

public class DemoMetodoGenerico {
	static <T extends Comparable<T>> boolean igualArrays (T[] x, T[] y){
		if (x.length != y.length)
			return false;
		for (int i = 0; i < x.length; i++)
			if(!x[i].equals(y[i]))
					return false; 
			return true; 
	}
	
	public static void main(String[] args) {
		Integer w[]={12,34,56};
		String v[]= {"Perez", "Sanchez", "Rodriguez"};
		
		System.out.println(exist(v,"Sanchez"));
		System.out.println(exist(w,12));
		
		System.out.println(exist(w,"Salas"));
		
	}
	
	static <T> boolean exist(T[] x, T y) {
		for (T e:x) {
			if (e.equals(y)) {
				return true;
			}
		}
		return false;
	}
}