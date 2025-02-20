/**
 * Clase que representa un nodo en una estructura de datos enlazada.
 * Contiene un dato genérico y una referencia al siguiente nodo.
 * 
 * @param <E> el tipo de dato almacenado en el nodo.
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class Node<E> {
    /** El dato almacenado en el nodo. */
    public E data;

    /** Referencia al siguiente nodo en la estructura enlazada. */
    public Node<E> next;

    /**
     * Constructor que inicializa un nodo con el dato proporcionado.
     * 
     * @param data el dato que se almacenará en el nodo.
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
