package deque;

public class ArrayDeque<T> {
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

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size++;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = Math.floorMod(nextLast + 1, items.length);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
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
        nextFirst = Math.floorMod(nextFirst + 1, items.length);
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return removedItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = Math.floorMod(nextLast - 1, items.length);
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
}
