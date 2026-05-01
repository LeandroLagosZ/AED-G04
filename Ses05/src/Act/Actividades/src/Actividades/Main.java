package Actividades;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        Tarea t1 = new Tarea("Diseñar BD", 2, "pendiente");
        Tarea t2 = new Tarea("Deploy produccion", 1, "pendiente");
        Tarea t3 = new Tarea("Documentar API", 3, "completada");
        Tarea t4 = new Tarea("Code review", 2, "pendiente");
        Tarea t5 = new Tarea("Corregir bug 42", 1, "completada");

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t4);
        gestor.agregarTarea(t5);

        System.out.println("Lista inicial");
        gestor.imprimirTareas();

        gestor.eliminarTarea(t4);

        System.out.println("Lista despues de eliminar una tarea");
        gestor.imprimirTareas();

        System.out.println("Buscar tarea Diseñar BD");
        System.out.println(gestor.contieneTarea(t1));

        System.out.println("Cantidad de tareas");
        System.out.println(gestor.contarTareas());

        System.out.println("Tarea mas prioritaria");
        System.out.println(gestor.obtenerTareaMasPrioritaria());

        gestor.invertirTareas();

        System.out.println("Lista invertida");
        gestor.imprimirTareas();
    }
}