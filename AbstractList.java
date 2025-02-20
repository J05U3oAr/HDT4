/**
 * Clase abstracta que representa una lista genérica.
 * 
 * @param <E> el tipo de elementos en la lista
 * 
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public abstract class AbstractList<E> implements IList<E> {
    
    /**
     * Tamaño actual de la lista.
     */
    protected int size;

    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista no contiene elementos, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Obtiene el tamaño actual de la lista.
     * 
     * @return el número de elementos en la lista.
     */
    public int size() {
        return size;
    }
}
