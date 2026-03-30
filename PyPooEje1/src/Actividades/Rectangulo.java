package Actividades;

public class Rectangulo {
	private Coordenada esquina1;
	private Coordenada esquina2;
	
	public Rectangulo(Coordenada c1, Coordenada c2) {
		this.esquina1 = c1;
		this.esquina2 = c2;
	}
	
	public Coordenada getEsquina1() {return esquina1;}
	public Coordenada getEsquina2() {return esquina2;}
	
	public void setEsquina1(Coordenada c) {this.esquina1 = c;}
	public void setEsquina2(Coordenada c) {this.esquina2 = c;}
	
	@Override
	public String toString() {
		return "("+esquina1+"),"+"("+esquina2+")";
	}
}
