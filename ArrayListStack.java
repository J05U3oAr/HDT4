import java.util.ArrayList;

public class ArrayListStack<E> extends AbstractStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    @Override
    public void push(E item) {
        list.add(item);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        size--;
        return list.remove(size);
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(size - 1);
    }
}
