package ACT1;

public class Rectangulo {
	private Coordenada esquina1;
	private Coordenada esquina2;
	private double[] bordesH= new double[2];
	private double[] bordesV= new double[2];
	
	public Rectangulo(Coordenada c1, Coordenada c2) {
		setEsquina1(c1);
		setEsquina2(c2);
		
		if (esquina1.getX()>esquina2.getX()) {
			bordesH[0]=esquina2.getX();
			bordesH[1]=esquina1.getX();
		}else {
			bordesH[0]=esquina1.getX();
			bordesH[1]=esquina2.getX();
		}
		
		if (esquina1.getY()>esquina2.getY()) {
			bordesV[0]=esquina2.getY();
			bordesV[1]=esquina1.getY();
		}else {
			bordesV[0]=esquina1.getY();
			bordesV[1]=esquina2.getY();
		}
	}
	
	public Coordenada getEsquina1() {
		return esquina1;
	}

	public void setEsquina1(Coordenada esquina1) {
		this.esquina1 = esquina1;
	}

	public Coordenada getEsquina2() {
		return esquina2;
	}

	public void setEsquina2(Coordenada esquina2) {
		this.esquina2 = esquina2;
	}
	
	public double[] getBordesH(){
		return bordesH;
	}
	
	public double[] getBordesV() {
		return bordesV;
	}

	public double calculoArea() {
		double ancho = bordesH[1] - bordesH[0];
	    double alto = bordesV[1] - bordesV[0];
	    
	    return ancho * alto;
	}
	
	@Override
	public String toString() {
		return "( "+esquina1+", "+esquina2+" )";
	}
	
}
