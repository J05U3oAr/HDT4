/**
 * Clase de fábrica para la creación de instancias de diferentes implementaciones de pilas.
 * Permite la creación de pilas basadas en {@link ArrayList}, {@link Vector} o listas enlazadas.
 * 
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class StackFactory {
    
    /**
     * Crea y devuelve una instancia de una pila basada en el tipo especificado.
     * 
     * @param <E> el tipo de elementos que contendrá la pila.
     * @param stackType el tipo de pila a crear ("ArrayList", "Vector" o "List").
     * @param listType el tipo de lista a utilizar si la pila es basada en lista 
     *                 ("SinglyLinkedList" o "DoublyLinkedList").
     * @return una instancia de {@link IStack} con la implementación correspondiente.
     * @throws IllegalArgumentException si el tipo de pila o lista no es reconocido.
     */
    public static <E> IStack<E> createStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("ArrayList")) {
            return new ArrayListStack<>();
        } else if (stackType.equalsIgnoreCase("Vector")) {
            return new VectorStack<>();
        } else if (stackType.equalsIgnoreCase("List")) {
            if (listType.equalsIgnoreCase("SinglyLinkedList")) {
                return new ListStack<>(new SinglyLinkedList<>());
            } else if (listType.equalsIgnoreCase("DoublyLinkedList")) {
                return new ListStack<>(new DoublyLinkedList<>());
            } else {
                throw new IllegalArgumentException("Tipo de lista no reconocido: " + listType);
            }
        } else {
            throw new IllegalArgumentException("Tipo de pila no reconocido: " + stackType);
        }
    }
}
