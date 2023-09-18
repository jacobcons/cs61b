package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private static final int INITIAL_SIZE = 8;
    private T[] items;
    private int size;

    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int counter = 0;
        for (int i = nextIndex(nextFirst); counter < size; i = nextIndex(i)) {
            temp[counter] = items[i];
            counter++;
        }
        items = temp;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = prevIndex(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = nextIndex(nextLast);
        size++;
    }

    public int size() {
        return size;
    }

    /* point to first element, print each element, print a space after if not the last element */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.get(i));
            if (i != size - 1) {
                System.out.print(" ");
            }
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        float usageRatio = (float) size / items.length;
        if (usageRatio < 0.25) {
            resize(items.length / 2);
        }

        nextFirst = nextIndex(nextFirst);
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return removedItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        float usageRatio = (float) size / items.length;
        if (usageRatio < 0.25) {
            resize(items.length / 2);
        }

        nextLast = prevIndex(nextLast);
        T removedItem = items[nextLast];
        items[nextLast] = null;
        size--;
        return removedItem;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[Math.floorMod(nextFirst + index + 1, items.length)];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;
        public ArrayDequeIterator() {
            pos = 0;
        }
        public boolean hasNext() {
            return pos < size;
        }
        public T next() {
            T returnItem = get(pos);
            pos += 1;
            return returnItem;
        }
    }

    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }

    private int prevIndex(int index) {
        return Math.floorMod(index - 1, items.length);
    }

    private int nextIndex(int index) {
        return Math.floorMod(index + 1, items.length);
    }
}
