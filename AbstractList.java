public abstract class AbstractList<E> implements IList<E> {
    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
