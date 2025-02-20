import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para las implementaciones de pilas y listas enlazadas.
 * Se utilizan pruebas con JUnit para verificar el comportamiento de las estructuras de datos.
 * 
 * Se prueban las siguientes estructuras:
 * - {@link ArrayListStack}
 * - {@link VectorStack}
 * - {@link ListStack} con {@link SinglyLinkedList} y {@link DoublyLinkedList}
 * - {@link SinglyLinkedList}
 * - {@link DoublyLinkedList}
 * 
 * @author Diego Calderón
 * @author Arodi Chavez
 * @author Derek Coronado
 * @version 1.0
 * @since 13/02/2025
 * @lastModified 20/02/2025
 */
public class Tests {
    private IStack<Integer> arrayListStack;
    private IStack<Integer> vectorStack;
    private IStack<Integer> listStack;
    private IList<Integer> singlyLinkedList;
    private IList<Integer> doublyLinkedList;

    /**
     * Configura las estructuras de datos antes de cada prueba.
     */
    @Before
    public void setUp() {
        arrayListStack = new ArrayListStack<>();
        vectorStack = new VectorStack<>();
        singlyLinkedList = new SinglyLinkedList<>();
        doublyLinkedList = new DoublyLinkedList<>();
        listStack = new ListStack<>(new SinglyLinkedList<>());
        listStack = new ListStack<>(new DoublyLinkedList<>());
    }

    /**
     * Prueba la funcionalidad de push y pop en una pila basada en {@link ArrayListStack}.
     */
    @Test
    public void testPushAndPopArrayListStack() {
        arrayListStack.push(10);
        arrayListStack.push(20);
        assertEquals(20, (int) arrayListStack.pop());
        assertEquals(10, (int) arrayListStack.pop());
    }

    /**
     * Prueba la funcionalidad de push y peek en una pila basada en {@link VectorStack}.
     */
    @Test
    public void testPushAndPeekVectorStack() {
        vectorStack.push(5);
        vectorStack.push(15);
        assertEquals(15, (int) vectorStack.peek());
        assertEquals(15, (int) vectorStack.pop());
        assertEquals(5, (int) vectorStack.peek());
    }

    /**
     * Prueba la funcionalidad de push y pop en una pila basada en {@link ListStack}.
     */
    @Test
    public void testPushAndPopListStack() {
        listStack.push(30);
        listStack.push(40);
        assertEquals(40, (int) listStack.pop());
        assertEquals(30, (int) listStack.pop());
    }

    /**
     * Prueba la funcionalidad de agregar y remover elementos en una {@link SinglyLinkedList}.
     */
    @Test
    public void testAddAndRemoveSinglyLinkedList() {
        singlyLinkedList.add(100);
        singlyLinkedList.add(200);
        assertEquals(100, (int) singlyLinkedList.remove());
        assertEquals(200, (int) singlyLinkedList.remove());
    }

    /**
     * Prueba la funcionalidad de agregar y remover elementos en una {@link DoublyLinkedList}.
     */
    @Test
    public void testAddAndRemoveDoublyLinkedList() {
        doublyLinkedList.add(300);
        doublyLinkedList.add(400);
        assertEquals(400, (int) doublyLinkedList.remove());
        assertEquals(300, (int) doublyLinkedList.remove());
    }
    
    /**
     * Prueba la funcionalidad de obtener un elemento de una {@link SinglyLinkedList}.
     */
    @Test
    public void testGetElementFromSinglyLinkedList() {
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        assertEquals(2, (int) singlyLinkedList.get(1));
    }

    /**
     * Prueba la funcionalidad de obtener un elemento de una {@link DoublyLinkedList}.
     */
    @Test
    public void testGetElementFromDoublyLinkedList() {
        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);
        assertEquals(20, (int) doublyLinkedList.get(1));
    }
}
