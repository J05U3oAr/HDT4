public class StackFactory {
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
