public class DoublyLinkedList<E> extends AbstractList<E> {
    private class DoublyNode<E> extends Node<E> {
        public Node<E> prev;

        public DoublyNode(E data) {
            super(data);
            this.prev = null;
        }
    }

    private DoublyNode<E> head;
    private DoublyNode<E> tail;

    @Override
    public void add(E element) {
        DoublyNode<E> newNode = new DoublyNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía");
        }

        E data = tail.data;
        if (head == tail) { // Solo un elemento en la lista
            head = null;
            tail = null;
        } else {
            tail = (DoublyNode<E>) tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<E> current;
        if (index < size / 2) { // Buscar desde el inicio
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else { // Buscar desde el final
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = ((DoublyNode<E>) current).prev;
            }
        }
        return current.data;
    }
}
