/**
 * Implementación de una pila (stack) basada en una lista.
 * Extiende {@link AbstractStack} y utiliza una instancia de {@link IList} para almacenar los elementos.
 * 
 * @param <E> el tipo de elementos almacenados en la pila.
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class ListStack<E> extends AbstractStack<E> {
    
    /** Lista utilizada para almacenar los elementos de la pila. */
    private IList<E> list;

    /**
     * Constructor que inicializa la pila con una implementación específica de {@link IList}.
     * 
     * @param list la lista subyacente que se utilizará para almacenar los elementos.
     */
    public ListStack(IList<E> list) {
        this.list = list;
    }

    /**
     * Agrega un elemento a la pila.
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
     * @return el elemento eliminado.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack está vacío");
        size--;
        return list.remove();
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * 
     * @return el elemento en la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack está vacío");
        return list.get(size - 1);
    }
}
