package Actividades;

public class ContainerRect {
	private int n;
	private static int numRec;
	
	Rectangulo[] rectangulos;
	double[] distancias;
	double[] areas;
	
	public static int getNumRec() {return numRec;}
	
	public ContainerRect(int n) {
		this.n = n;
		this.rectangulos = new Rectangulo[n];
		this.distancias = new double[n];
		this.areas = new double[n];
	}
	
	public void addRectangulo(Rectangulo r) {
		for(int i=0; i<n; i++) {
			if(rectangulos[i] == null) {
				rectangulos[i] = r;
				distancias[i] = r.getEsquina1().distancia(r.getEsquina2());
				
				double x = Math.abs(r.getEsquina1().getX()-r.getEsquina2().getX());
				double y = Math.abs(r.getEsquina1().getY()-r.getEsquina2().getY());
				
				areas[i] = x*y;
				
				numRec++;
				return;
			}
		}
		System.out.println("EL ARREGLO DE RECTANGULOS ESTÁ LLENO");
	}
	
	@Override
	public String toString() {
	    String texto = "";

	    texto += String.format("%-14s %-30s %-14s %-10s\n","Rectangulo","Coordenadas", "Distancia", "Area");

	    for (int i = 0; i < rectangulos.length; i++) {
	        if (rectangulos[i] != null) {
	            texto += String.format("%-14d %-30s %-14.2f %-10.2f\n",(i+1),rectangulos[i],distancias[i],areas[i]);
	        }
	    }

	    return texto;
	}
}
