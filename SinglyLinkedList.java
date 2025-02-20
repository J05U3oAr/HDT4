public class SinglyLinkedList<E> extends AbstractList<E> {
    private Node<E> head;

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }

        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
