public class StackFactory {
  
    public static <E> IStack<E> createStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("ArrayList")) {
            return new ArrayListStack<>();
        } else if (stackType.equalsIgnoreCase("Vector")) {
            return new VectorStack<>();
        } else if (stackType.equalsIgnoreCase("List")) {
            // Por simplicidad, se retorna la implementación ListStack.
            return new ListStack<>();
        } else {
            throw new IllegalArgumentException("Tipo de pila no reconocido: " + stackType);
        }
    }
}
