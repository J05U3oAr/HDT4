import java.util.LinkedList;
import java.util.List;

public class ListStack<E> extends AbstractStack<E> {
    private List<E> list = new LinkedList<>();

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
