/**
 * Implementación de una lista simplemente enlazada que extiende {@link AbstractList}.
 * 
 * @param <E> el tipo de elementos almacenados en la lista.
 * Implementa operaciones básicas como agregar, eliminar y obtener elementos por índice.
 * 
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class SinglyLinkedList<E> extends AbstractList<E> {
    /** Referencia al primer nodo de la lista. */
    private Node<E> head;

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param element el elemento a agregar.
     */
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * 
     * @return el elemento eliminado.
     * @throws IllegalStateException si la lista está vacía.
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }

        E data = head.data;
        head = head.next;
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

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
