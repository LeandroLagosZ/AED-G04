package Ejer3;

public class Chocolatina {
	private String marca;
	public Chocolatina(String marca) {
		this.marca = marca;
	}

	public String getMarca(){
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return marca;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null || getClass()!=obj.getClass()) {
			return false;
		}
		Chocolatina c2=(Chocolatina) obj;
		if (c2.getMarca().equals(marca)) {
			return true;
		}
		return false;
	}
}
