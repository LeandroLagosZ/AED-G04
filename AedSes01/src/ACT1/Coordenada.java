package ACT1;
import java.util.*;

public class Coordenada {

	private double x;
	private double y;
	public Coordenada() {
		x=y=0;
		System.out.println("Coordenada inicializada SIN VALOR");
	}
	public Coordenada(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Coordenada(Coordenada c) {
		x=c.getX();
		y=c.getY();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	static double distancia(Coordenada c1, Coordenada c2) {
		double dx=c1.getX()-c2.getX();
		double dy=c1.getY()-c2.getY();
		double suma=(dx*dx)+(dy*dy);
		return (Math.sqrt(suma));
	}
	
	double distancia(Coordenada c1) {
		double dx=c1.getX()-this.x;
		double dy=c1.getY()-this.y;
		double suma=(dx*dx)+(dy*dy);
		return (Math.sqrt(suma));
	}
		
	@Override
	public String toString() {
		return "[ "+this.x+"; "+this.y+" ]";
	}
	
}
