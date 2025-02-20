/**
 * Clase abstracta que representa una pila genérica.
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
public abstract class AbstractStack<E> implements IStack<E> {
    
    /**
     * Tamaño actual de la pila.
     */
    protected int size;

    /**
     * Constructor por defecto que inicializa el tamaño de la pila en cero.
     */
    public AbstractStack() {
        this.size = 0;
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila no contiene elementos, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Obtiene el tamaño actual de la pila.
     * 
     * @return el número de elementos en la pila.
     */
    @Override
    public int size() {
        return size;
    }
}
