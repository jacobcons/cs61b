package deque;

public class LinkedListDeque<T> {
    private class ItemNode {
        private T item;
        private ItemNode next;
        private ItemNode prev;
        public ItemNode(T i, ItemNode n, ItemNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private ItemNode sentinelFirst;
    private ItemNode sentinelLast;
    private int size;

    public LinkedListDeque() {
        sentinelFirst = new ItemNode(null, null, null);
        sentinelLast = new ItemNode(null, null, null);
        sentinelFirst.next = sentinelLast;
        sentinelLast.prev = sentinelFirst;
        size = 0;
    }

    public void addFirst(T item) {
        ItemNode oldFirst = sentinelFirst.next;
        sentinelFirst.next = new ItemNode(item, oldFirst, sentinelFirst);
        ItemNode newFirst = sentinelFirst.next;
        oldFirst.prev = newFirst;
        size++;
    }

    public void addLast(T item) {
        ItemNode oldLast = sentinelLast.prev;
        oldLast.next = new ItemNode(item, sentinelLast, oldLast);
        ItemNode newLast = oldLast.next;
        sentinelLast.prev = newLast;
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
        ItemNode p = sentinelFirst.next;
        while (p != sentinelLast) {
            System.out.print(p.item);
            if (p.next != sentinelLast) {
                System.out.print(" ");
            }
            p = p.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ItemNode first = sentinelFirst.next;
        ItemNode second = first.next;
        sentinelFirst.next = second;
        second.prev = sentinelFirst;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        ItemNode last = sentinelLast.prev;
        ItemNode secondToLast = last.prev;
        secondToLast.next = sentinelLast;
        sentinelLast.prev = secondToLast;
        size--;
        return last.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        ItemNode p = sentinelFirst;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.item;
    }

    private ItemNode getNodeRecursive(int index) {
        if (index == 0) {
            return sentinelFirst.next;
        }
        return getNodeRecursive(index - 1).next;
    }

    public T getRecursive(int index) {
        return getNodeRecursive(index).item;
    }
}
