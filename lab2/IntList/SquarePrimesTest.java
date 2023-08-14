package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesSingle() {
        IntList lst = IntList.of(2);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesRepeat() {
        IntList lst = IntList.of(2, 3, 5, 2, 6);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 9 -> 25 -> 4 -> 6", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesEarly() {
        IntList lst = IntList.of(17, 18, 2, 3, 5, 7);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("289 -> 18 -> 4 -> 9 -> 25 -> 49", lst.toString());
        assertTrue(changed);
    }
}
