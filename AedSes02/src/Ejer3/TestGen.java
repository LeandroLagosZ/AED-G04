package Ejer3;

public class TestGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cajoneria estante=new Cajoneria(5);
		
		Caja<Golosina> caja1 = new Caja<>("Rojo", new Golosina("Galleta", 60));
        Caja<Golosina> caja2 = new Caja<>("Azul", new Golosina("Gomitas", 30));
        Caja<Golosina> caja3 = new Caja<>("Morado", new Golosina("Galleta", 60));
        
        estante.add(caja1);
        estante.add(caja2);
        estante.add(caja3);

        
        System.out.println(estante);
        Golosina busca=new Golosina("Gomitas",30);
        System.out.println(estante.search(busca));
        
        Object o=estante.delete(busca);
        if (o!=null) {
        	System.out.println("Se eliminó: "+o);
        }
        
        Golosina cuenta=new Golosina("Galleta",60);
        int repe=estante.contar(cuenta);
        System.out.println(cuenta+"   Se repite "+repe+" veces.");
        
        System.out.println(estante);
        
        Cajoneria estanteChocolates=new Cajoneria(2);
        Caja<Chocolatina> caja4 = new Caja<>("Rojo", new Chocolatina("Milka"));
        Caja<Chocolatina> caja5 = new Caja<>("Blanco", new Chocolatina("Toblerone"));
        
        estanteChocolates.add(caja4);
        estanteChocolates.add(caja5);
        
        System.out.println(estanteChocolates);
        
        Chocolatina buscac = new Chocolatina("Toblerone");
        System.out.println(estanteChocolates.search(buscac));
        
        o = estanteChocolates.delete(buscac);
        if (o != null) {
            System.out.println("\nSe eliminó: " + o);
        }

        System.out.println(estanteChocolates);
	}

}
