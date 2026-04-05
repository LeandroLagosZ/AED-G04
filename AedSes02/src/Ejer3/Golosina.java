package Ejer3;

public class Golosina {
	private String nombre;
	private double peso;
	public Golosina(String nombre, double peso) {
		this.nombre = nombre;
		this.peso = peso;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){ 
		this.nombre=nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return nombre+" - "+peso+" g.";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null || getClass()!=obj.getClass()) {
			return false;
		}
		Golosina g2=(Golosina) obj;
		if (g2.getNombre().equals(nombre) && g2.getPeso()==peso){
			return true;
		}
		return false;
	}
}
