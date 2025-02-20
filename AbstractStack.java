public abstract class AbstractStack<E> implements Stack<E> {
    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
