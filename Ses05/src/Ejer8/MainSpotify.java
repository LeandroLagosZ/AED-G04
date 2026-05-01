package Ejer8;

public class MainSpotify {
    public static void main(String[] args) {
        ColaReproduccion<Cancion> spotify = new ColaReproduccion<>();

        spotify.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        spotify.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        spotify.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        spotify.agregarCancion(new Cancion("Starboy", "The Weeknd", 230));
        spotify.agregarCancion(new Cancion("Yellow", "Coldplay", 266));
        spotify.agregarCancion(new Cancion("Mockingbird", "Eminem", 250));

        System.out.println("Cola de Reproducción Inicial");
        spotify.mostrarCola();

        System.out.println("\nAvanzando 3 canciones");
        for (int i = 0; i < 3; i++) {
            System.out.println("Reproduciendo ahora: " + spotify.reproducirSiguiente());
        }

        System.out.println("\nRetrocediendo");
        System.out.println("Anterior: " + spotify.reproducirAnterior());

        int totalSegundos = spotify.duracionTotal();
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        System.out.println("\nDuración total de la cola: "+ minutos+segundos);

        System.out.println("\nMezclando...(Modo Shuffle)");
        spotify.mezclar();
        spotify.mostrarCola();
    }
}