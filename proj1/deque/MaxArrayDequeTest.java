package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    class MaxComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    class MinComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

    class SevenComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a == 7 ? 1 : -1;
        }
    }
    @Test
    public void comparatorTest() {
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(new MaxComparator());
        l.addLast(3);
        l.addLast(10);
        l.addLast(7);
        l.addLast(5);
        l.addLast(9);
        assertEquals(l.max(), (Integer) 10);
        assertEquals(l.max(new MinComparator()), (Integer) 3);
        assertEquals(l.max(new SevenComparator()), (Integer) 7);
    }
}
