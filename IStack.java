/**
 * Interfaz que define las operaciones básicas para una estructura de pila (stack).
 * 
 * @param <E> el tipo de elementos almacenados en la pila.
 * @autor Diego Calderón
 * @autor Arodi Chavez
 * @autor Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public interface IStack<E> {
    
    /**
     * Agrega un elemento a la cima de la pila.
     * 
     * @param element el elemento a agregar.
     */
    void push(E element);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * 
     * @return el elemento eliminado.
     * @throws IllegalStateException si la pila está vacía.
     */
    E pop();

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * 
     * @return el elemento en la cima de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    E peek();

    /**
     * Obtiene el número de elementos en la pila.
     * 
     * @return la cantidad de elementos en la pila.
     */
    int size();

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();
}
