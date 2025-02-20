/**
 * Interfaz que define las operaciones básicas para una estructura de lista.
 * 
 * @param <E> el tipo de elementos almacenados en la lista.
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public interface IList<E> {
    
    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param element el elemento a agregar.
     */
    void add(E element);

    /**
     * Elimina y devuelve el último elemento de la lista.
     * 
     * @return el elemento eliminado.
     */
    E remove();

    /**
     * Obtiene el elemento en la posición especificada.
     * 
     * @param index la posición del elemento a obtener.
     * @return el elemento en la posición indicada.
     */
    E get(int index);

    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el número de elementos en la lista.
     * 
     * @return la cantidad de elementos en la lista.
     */
    int size();
}
