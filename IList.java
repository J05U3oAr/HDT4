public interface IList<E> {
    void add(E element);
    E remove();
    E get(int index);
    boolean isEmpty();
    int size();
}