/**
 * Implementación de una lista doblemente enlazada que extiende {@link AbstractList}.
 * 
 * @param <E> el tipo de elementos almacenados en la lista.
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class DoublyLinkedList<E> extends AbstractList<E> {
    /**
     * Clase interna que representa un nodo en la lista doblemente enlazada.
     * 
     * @param <E> el tipo de datos almacenado en el nodo.
     */
    private class DoublyNode<E> extends Node<E> {
        /** Referencia al nodo anterior en la lista. */
        public Node<E> prev;

        /**
         * Constructor que inicializa un nodo con un valor de datos.
         * 
         * @param data el dato a almacenar en el nodo.
         */
        public DoublyNode(E data) {
            super(data);
            this.prev = null;
        }
    }

    /** Referencia al primer nodo de la lista. */
    private DoublyNode<E> head;
    /** Referencia al último nodo de la lista. */
    private DoublyNode<E> tail;

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param element el elemento a agregar.
     */
    @Override
    public void add(E element) {
        DoublyNode<E> newNode = new DoublyNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     * 
     * @return el elemento eliminado.
     * @throws IllegalStateException si la lista está vacía.
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }

        E data = tail.data;
        if (head == tail) { // Solo un elemento en la lista
            head = null;
            tail = null;
        } else {
            tail = (DoublyNode<E>) tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    /**
     * Obtiene el elemento en la posición especificada.
     * 
     * @param index la posición del elemento a obtener.
     * @return el elemento en la posición indicada.
     * @throws IndexOutOfBoundsException si el índice está fuera del rango válido.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<E> current;
        if (index < size / 2) { // Buscar desde el inicio
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else { // Buscar desde el final
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = ((DoublyNode<E>) current).prev;
            }
        }
        return current.data;
    }
}