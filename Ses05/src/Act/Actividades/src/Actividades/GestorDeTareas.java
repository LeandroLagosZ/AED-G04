package Actividades;

public class GestorDeTareas<T extends Comparable<T>> {
    private ListLinked<T> lista;

    public GestorDeTareas() {
        lista = new ListLinked<>();
    }

    public void agregarTarea(T tarea) {
        lista.insertLast(tarea);
    }

    public boolean eliminarTarea(T tarea) {
        return lista.removeNode(tarea);
    }

    public boolean contieneTarea(T tarea) {
        return lista.search(tarea);
    }

    public void imprimirTareas() {
        lista.print();
    }

    public int contarTareas() {
        return lista.length();
    }

    public T obtenerTareaMasPrioritaria() {
        if (lista.isEmptyList()) {
            return null;
        }

        Node<T> actual = lista.getFirst();
        T mayorPrioridad = actual.value;

        while (actual != null) {
            if (actual.value.compareTo(mayorPrioridad) < 0) {
                mayorPrioridad = actual.value;
            }

            actual = actual.next;
        }

        return mayorPrioridad;
    }

    public void invertirTareas() {
        lista.reverse();
    }
}