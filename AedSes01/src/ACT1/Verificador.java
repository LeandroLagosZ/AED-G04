package ACT1;

public class Verificador {
	public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
		double[] bh1=r1.getBordesH();
		double[] bv1=r1.getBordesV();
		double[] bh2=r2.getBordesH();
		double[] bv2=r2.getBordesV();
		
		return (bh1[0]<bh2[1] && bh1[1]>bh2[0] && bv1[0]<bv2[1] && bv1[1]>bv2[0])? true: false;
	}
	public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
		double[] bh1=r1.getBordesH();
		double[] bv1=r1.getBordesV();
		double[] bh2=r2.getBordesH();
		double[] bv2=r2.getBordesV();
		
		if(bv1[0]==bv2[1] || bv1[1]==bv2[0]) {
			if (bh1[0]<=bh2[1] && bh1[1]>=bh2[0]) {
				return true;
			}
		}
		
		if(bh1[0]==bh2[1] || bh1[1]==bh2[0]) {
			if (bv1[0]<=bv2[1] && bv1[1]>=bv2[0]) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
		if (!esSobrePos(r1,r2) && !esJunto(r1,r2)) 
			return true;
		else return false;
	}
}