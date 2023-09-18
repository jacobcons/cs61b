package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void getTest() {
        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();
        assertNull(l.get(0));
        assertNull(l.getRecursive(0));
        l.addLast(3);
        assertEquals((int) l.get(0), 3);
        assertEquals((int) l.getRecursive(0), 3);
        l.addLast(7);
        l.addLast(10);
        assertEquals((int) l.get(1), 7);
        assertEquals((int) l.getRecursive(1), 7);
        assertEquals((int) l.get(2), 10);
        assertEquals((int) l.getRecursive(2), 10);
        assertNull(l.get(3));
        assertNull(l.getRecursive(3));
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void printTest() {
        LinkedListDeque<Integer> l = new LinkedListDeque<Integer>();
        l.printDeque();
        l.addLast(3);
        l.addLast(7);
        l.addLast(10);
        l.printDeque();
    }

    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> myImplementation = new LinkedListDeque<>();
        java.util.LinkedList<Integer> javaImplementation = new java.util.LinkedList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                myImplementation.addLast(randVal);
                javaImplementation.addLast(randVal);
            } else if (operationNumber == 1) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                myImplementation.addFirst(randVal);
                javaImplementation.addFirst(randVal);
            } else if (operationNumber == 2) {
                // size
                int mySize = myImplementation.size();
                int javaSize = javaImplementation.size();
                assertEquals(mySize, javaSize);
            } else if (operationNumber == 3 && !myImplementation.isEmpty()) {
                // removeLast
                int myLast = myImplementation.removeLast();
                int javaLast = javaImplementation.removeLast();
                assertEquals(myLast, javaLast);
            } else if (operationNumber == 4 && !myImplementation.isEmpty()) {
                // removeFirst
                int myFirst = myImplementation.removeFirst();
                int javaFirst = javaImplementation.removeFirst();
                assertEquals(myFirst, javaFirst);
            }
        }
    }

    @Test
    public void iteratorTest() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        int i = 1;
        for (int x: l) {
            assertEquals(x, i);
            i += 1;
        }
    }

    @Test
    public void equalsTest() {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        LinkedListDeque<Integer> m = new LinkedListDeque<>();
        m.addLast(1);
        m.addLast(2);
        m.addLast(3);

        // same contents => true
        assertEquals(l, m);
        // different lengths => false
        m.removeLast();
        assertNotEquals(l, m);

        // different contents => false
        m.addLast(4);
        assertNotEquals(l, m);
    }
}
