package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

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
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
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

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
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
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigALDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
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
        ArrayDeque<Integer> l = new ArrayDeque<Integer>();
        assertNull(l.get(0));
        l.addLast(3);
        assertEquals((int) l.get(0), 3);
        l.addLast(7);
        l.addLast(10);
        assertEquals((int) l.get(1), 7);
        assertEquals((int) l.get(2), 10);
        assertNull(l.get(3));
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void printTest() {
        ArrayDeque<Integer> l = new ArrayDeque<Integer>();
        l.printDeque();
        l.addLast(3);
        l.addLast(7);
        l.addLast(10);
        l.printDeque();
    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> myImplementation = new ArrayDeque<>();
        java.util.ArrayDeque<Integer> javaImplementation = new java.util.ArrayDeque<>();

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
    public void resizeBiggerTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        for (int i = 1; i <= 23; i++) {
            l.addLast(i);
        }
    }

    @Test
    public void resizeSmallerTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        for (int i = 1; i <= 20; i++) {
            l.addLast(i);
        }
        for (int i = 1; i <= 18; i++) {
            l.removeLast();
        }
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
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
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        ArrayDeque<Integer> m = new ArrayDeque<>();
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

        // test same array deque & linked list deque are equal
        LinkedListDeque<Integer> l2 = new LinkedListDeque<>();
        l2.addLast(1);
        l2.addLast(2);
        l2.addLast(3);
        assertEquals(l, l2);
    }
}
