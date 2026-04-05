package Ejer2;

public class Principal {
	public static void main(String[] args) {
		Bolsa < Chocolatina > bolsaCho = new Bolsa <Chocolatina>(3);
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("milka");
		Chocolatina c2 = new Chocolatina("ferrero");
		bolsaCho.add(c);
		bolsaCho.add(c1);
		bolsaCho.add(c2);

		Bolsa<Golosina> bolsaGol= new Bolsa<Golosina>(3);
		bolsaGol.add(new Golosina("Gomita",50));
		bolsaGol.add(new Golosina("Chupetin",100));
		bolsaGol.add(new Golosina("Caramelo",30));
		
		mostrarBolsa(bolsaCho);
		mostrarBolsa(bolsaGol);
	}
	
	public static <T> void mostrarBolsa(Bolsa<T> bolsa) {
		for (T objeto: bolsa) {
			System.out.println(objeto);
		}
	}
}
