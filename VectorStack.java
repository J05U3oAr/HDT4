import java.util.Vector;

public class VectorStack<E> extends AbstractStack<E> {
    private Vector<E> vector = new Vector<>();

    @Override
    public void push(E item) {
        vector.add(item);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        size--;
        return vector.remove(size);
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return vector.get(size - 1);
    }
}
