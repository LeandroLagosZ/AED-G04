package Ejer8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColaReproduccion<T> {
    private NodeDoble<T> first;
    private NodeDoble<T> last;
    private NodeDoble<T> actual;

    public ColaReproduccion() {
        this.first = null;
        this.last = null;
        this.actual = null;
    }

    public void agregarCancion(T cancion) {
        NodeDoble<T> nuevo = new NodeDoble<>(cancion);
        if (first == null) {
            first = last = actual = nuevo;
        } else {
            last.next = nuevo;
            nuevo.prev = last;
            last = nuevo;
        }
    }

    public T reproducirSiguiente() {
        if (actual != null && actual.next != null) {
            actual = actual.next;
            return actual.value;
        }
        return (actual != null) ? actual.value : null;
    }

    public T reproducirAnterior() {
        if (actual != null && actual.prev != null) {
            actual = actual.prev;
            return actual.value;
        }
        return (actual != null) ? actual.value : null;
    }

    public void mezclar() {
        if (first == null) return;
        List<T> temp = new ArrayList<>();
        NodeDoble<T> aux = first;
        while (aux != null) {
            temp.add(aux.value);
            aux = aux.next;
        }
        Collections.shuffle(temp);
        first = last = null;
        for (T item : temp) {
            agregarCancion(item);
        }
    }

    public void mostrarCola() {
        NodeDoble<T> aux = first;
        int i = 1;
        while (aux != null) {
            String prefix = (aux == actual) ? "- " : i + ". ";
            System.out.println(prefix + aux.value);
            aux = aux.next;
            i++;
        }
    }

    public int duracionTotal() {
        int total = 0;
        NodeDoble<T> aux = first;
        while (aux != null) {
            if (aux.value instanceof Cancion) {
                total += ((Cancion) aux.value).getDuracionSeg();
            }
            aux = aux.next;
        }
        return total;
    }
}