package ACT1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner (System.in);
		double temp1, temp2;
		System.out.println("Ingrese una esquina del primer rectángulo: ");
		System.out.print("X: ");
		temp1=sc.nextDouble();
		System.out.print("Y: ");
		temp2=sc.nextDouble();
		Coordenada c11=new Coordenada(temp1, temp2);
		
		System.out.println("Ingrese la esquina opuesta del primer rectángulo: ");
		System.out.print("X: ");
		temp1=sc.nextDouble();
		System.out.print("Y: ");
		temp2=sc.nextDouble();
		Coordenada c12=new Coordenada(temp1, temp2);
		
		Rectangulo r1=new Rectangulo(c11,c12);
		
		System.out.println("Ingrese una esuqina del segundo rectángulo: ");
		System.out.print("X: ");
		temp1=sc.nextDouble();
		System.out.print("Y: ");
		temp2=sc.nextDouble();
		Coordenada c21=new Coordenada(temp1, temp2);
		
		System.out.println("Ingrese la esquina opuesta del segundo rectángulo: ");
		System.out.print("X: ");
		temp1=sc.nextDouble();
		System.out.print("Y: ");
		temp2=sc.nextDouble();
		Coordenada c22=new Coordenada(temp1, temp2);
		
		Rectangulo r2=new Rectangulo(c21,c22);
		
		System.out.print("Rectángulo A: ");
		informacion(r1);
		System.out.print("Rectángulo B: ");
		informacion(r2);
		System.out.print("Rectángulos A y B ");
		
		if(Verificador.esSobrePos(r1, r2)) {
			System.out.print("se sobreponen.\n");
			Rectangulo sobre= rectanguloSobre(r1,r2);
			System.out.print("Área de sobreposición: "+sobre.calculoArea());
		}else if(Verificador.esJunto(r1, r2)) {
			System.out.print("se juntan.\n");
		}else {
			System.out.print("son disjuntos.\n");
		}
	}
	
	public static void informacion(Rectangulo r) {
		System.out.print(r+"\n");
	}
	public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
	    double[] bh1 = r1.getBordesH();
	    double[] bv1 = r1.getBordesV();
	    double[] bh2 = r2.getBordesH();
	    double[] bv2 = r2.getBordesV();

	    double izqCruce, derCruce, infCruce, supCruce;

	    if (bh1[0] > bh2[0]) {
	        izqCruce = bh1[0];
	    } else {
	        izqCruce = bh2[0];
	    }

	    if (bh1[1] < bh2[1]) {
	        derCruce = bh1[1];
	    } else {
	        derCruce = bh2[1];
	    }

	    if (bv1[0] > bv2[0]) {
	        infCruce = bv1[0];
	    } else {
	        infCruce = bv2[0];
	    }

	    if (bv1[1] < bv2[1]) {
	        supCruce = bv1[1];
	    } else {
	        supCruce = bv2[1];
	    }

	    Coordenada c1 = new Coordenada(izqCruce, infCruce);
	    Coordenada c2 = new Coordenada(derCruce, supCruce);
	    return new Rectangulo(c1, c2);
	}

}
