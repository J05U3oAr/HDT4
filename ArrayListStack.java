/**
 * Implementación de una pila utilizando un ArrayList como estructura subyacente.
 * 
 * @param <E> el tipo de elementos en la pila
 * 
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
import java.util.ArrayList;

public class ArrayListStack<E> extends AbstractStack<E> {
    
    /**
     * Lista subyacente que almacena los elementos de la pila.
     */
    private ArrayList<E> list = new ArrayList<>();

    /**
     * Agrega un elemento a la cima de la pila.
     * 
     * @param item el elemento a agregar.
     */
    @Override
    public void push(E item) {
        list.add(item);
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * 
     * @return el elemento eliminado de la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        size--;
        return list.remove(size);
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * 
     * @return el elemento en la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(size - 1);
    }
}
