import java.util.Vector;

/**
 * Implementación de una pila (stack) basada en {@link Vector}.
 * Esta clase extiende {@link AbstractStack} y proporciona operaciones básicas de pila,
 * como push, pop y peek.
 * 
 * @param <E> el tipo de elementos almacenados en la pila.
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class VectorStack<E> extends AbstractStack<E> {
    /** Vector interno que almacena los elementos de la pila. */
    private Vector<E> vector = new Vector<>();

    /**
     * Agrega un elemento a la parte superior de la pila.
     * 
     * @param item el elemento a agregar.
     */
    @Override
    public void push(E item) {
        vector.add(item);
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * 
     * @return el elemento eliminado.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        size--;
        return vector.remove(size);
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * 
     * @return el elemento en la parte superior de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return vector.get(size - 1);
    }
}
