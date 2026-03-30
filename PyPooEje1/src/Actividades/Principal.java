package Actividades;

public class Principal {

	public static void main(String[] args) {
		ContainerRect contenedor = new ContainerRect(10);
		
		Rectangulo a = new Rectangulo(new Coordenada(1.5,0.3), new Coordenada(7.6, 2.2));
		contenedor.addRectangulo(a);
		
		Rectangulo b = new Rectangulo(new Coordenada(4.0,4.2), new Coordenada(9.4, -2.5));
		contenedor.addRectangulo(b);
		
		System.out.println(contenedor);
		System.out.println("Cantidad de rectangulos almacenados: "+ ContainerRect.getNumRec());
	}
}
