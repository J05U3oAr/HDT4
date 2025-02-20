public abstract class AbstractStack<E> implements IStack<E> {
    protected int size;

    public AbstractStack() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
