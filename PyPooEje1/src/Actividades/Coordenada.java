package Actividades;

public class Coordenada {
	private double x;
	private double y;
	
	public Coordenada() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordenada(double y, double x) {
		this.x = x;
		this.y = y;
	}
	
	public Coordenada(Coordenada c) {
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public double getX() {return this.x;}
	public double getY() {return this.y;}
	
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
	
	public double distancia (Coordenada c) {
		double a = Math.pow(c.getX()-this.x,2);
		double b = Math.pow(c.getY()-this.y,2);
		double resultado = Math.sqrt(a+b);
		return resultado;
	}
	
	public static double distancia (Coordenada c1, Coordenada c2) {
		double a = Math.pow(c1.getX()-c2.getX(),2);
		double b = Math.pow(c2.getY()-c2.getY(),2);
		double resultado = Math.sqrt(a+b);
		return resultado;
	}
	
	@Override
	public String toString() {
		return "["+this.x+"],"+"["+this.y+"]";
	}
}
