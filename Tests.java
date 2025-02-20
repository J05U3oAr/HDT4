import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class Tests {
    private IStack<Integer> arrayListStack;
    private IStack<Integer> vectorStack;
    private IStack<Integer> listStack;
    private IList<Integer> singlyLinkedList;
    private IList<Integer> doublyLinkedList;

    @Before
    public void setUp() {
        arrayListStack = new ArrayListStack<>();
        vectorStack = new VectorStack<>();
        singlyLinkedList = new SinglyLinkedList<>();
        doublyLinkedList = new DoublyLinkedList<>();
        listStack = new ListStack<>(new SinglyLinkedList<>());
        listStack = new ListStack<>(new DoublyLinkedList<>());
    }

    @Test
    public void testPushAndPopArrayListStack() {
        arrayListStack.push(10);
        arrayListStack.push(20);
        assertEquals(20, (int) arrayListStack.pop());
        assertEquals(10, (int) arrayListStack.pop());
    }

    @Test
    public void testPushAndPeekVectorStack() {
        vectorStack.push(5);
        vectorStack.push(15);
        assertEquals(15, (int) vectorStack.peek());
        assertEquals(15, (int) vectorStack.pop());
        assertEquals(5, (int) vectorStack.peek());
    }

    @Test
    public void testPushAndPopListStack() {
        listStack.push(30);
        listStack.push(40);
        assertEquals(40, (int) listStack.pop());
        assertEquals(30, (int) listStack.pop());
    }

    @Test
    public void testAddAndRemoveSinglyLinkedList() {
        singlyLinkedList.add(100);
        singlyLinkedList.add(200);
        assertEquals(100, (int) singlyLinkedList.remove());
        assertEquals(200, (int) singlyLinkedList.remove());
    }

    @Test
    public void testAddAndRemoveDoublyLinkedList() {
    doublyLinkedList.add(300);
    doublyLinkedList.add(400);
    assertEquals(400, (int) doublyLinkedList.remove());
    assertEquals(300, (int) doublyLinkedList.remove());
    }
    
    @Test
    public void testGetElementFromSinglyLinkedList() {
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        assertEquals(2, (int) singlyLinkedList.get(1));
    }

    @Test
    public void testGetElementFromDoublyLinkedList() {
        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);
        assertEquals(20, (int) doublyLinkedList.get(1));
    }
}