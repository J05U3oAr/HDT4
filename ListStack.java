import java.util.List;

public class ListStack<E> extends AbstractStack<E> {
    private IList<E> list;

    public ListStack(IList<E> list) {
        this.list = list;
    }

    @Override
    public void push(E item) {
        list.add(item);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        size--;
        return list.remove();
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(size - 1);
    }
}
